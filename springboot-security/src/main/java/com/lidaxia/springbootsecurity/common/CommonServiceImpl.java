package com.lidaxia.springbootsecurity.common;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.common.restResult.ResultGenerator;
import com.lidaxia.common.utils.CopyUtil;
import com.lidaxia.springbootsecurity.common.pojo.PageCondition;
import com.lidaxia.springbootsecurity.common.pojo.PageInfo;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 15:44（
 */
@Service
public class CommonServiceImpl<V, E, T> implements CommonService<V, E, T> {

    private Class<V> entityVoClass;//实体类Vo

    private Class<E> entityClass;//实体类

    @Autowired
    private CommonRepository<E, T> commonRepository;//注入实体类仓库

    public CommonServiceImpl() {
        Type[] types = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
        this.entityVoClass = (Class<V>) types[0];
        this.entityClass = (Class<E>) types[1];
    }

    @Override
    public RestResult<PageInfo<V>> page(V entityVo) {
        //实体类缺失分页信息
        if (!(entityVo instanceof PageCondition)) {
            throw new RuntimeException("实体类" + entityVoClass.getName() + "未继承PageCondition。");
        }
        PageCondition pageCondition = (PageCondition) entityVo;
        Page<E> page = commonRepository.findAll(Example.of(CopyUtil.copy(entityVo, entityClass)), pageCondition.getPageable());
        return ResultGenerator.genSuccessResult(PageInfo.of(page, entityVoClass));
    }

    @Override
    public RestResult<List<V>> list(V entityVo) {
        List<E> entityList = commonRepository.findAll(Example.of(CopyUtil.copy(entityVo, entityClass)));
        List<V> entityModelList = CopyUtil.copyList(entityList, entityVoClass);
        return ResultGenerator.genSuccessResult(entityModelList);
    }

    @Override
    public RestResult<V> get(T id) {
        Optional<E> optionalE = commonRepository.findById(id);
        if (!optionalE.isPresent()) {
            throw new RuntimeException("ID不存在！");
        }
        return ResultGenerator.genSuccessResult(CopyUtil.copy(optionalE.get(), entityVoClass));
    }

    @Override
    public RestResult<V> save(V entityVo) {
        //传进来的对象（属性可能残缺）
        E entity = CopyUtil.copy(entityVo, entityClass);

        //最终要保存的对象
        E entityFull = entity;

        //为空的属性值，忽略属性，BeanUtils复制的时候用到
        List<String> ignoreProperties = new ArrayList<String>();

        //获取最新数据，解决部分更新时jpa其他字段设置null问题
        try {
            //反射获取Class的属性（Field表示类中的成员变量）
            for (Field field : entity.getClass().getDeclaredFields()) {
                //获取授权
                field.setAccessible(true);
                //属性名称
                String fieldName = field.getName();
                //属性的值
                Object fieldValue = field.get(entity);

                //找出Id主键
                if (field.isAnnotationPresent(Id.class) && !StringUtils.isEmpty(fieldValue)) {
                    Optional<E> one = commonRepository.findById((T) fieldValue);
                    if (one.isPresent()) {
                        entityFull = one.get();
                    }
                }

                //找出值为空的属性，值为空则为忽略属性，或者被NotFound标注，我们复制的时候不进行赋值
                if(null == fieldValue || field.isAnnotationPresent(NotFound.class)){
                    ignoreProperties.add(fieldName);
                }
            }
            /*
                org.springframework.beans BeanUtils.copyProperties(A,B); 是A中的值付给B
                org.apache.commons.beanutils; BeanUtils.copyProperties(A,B);是B中的值付给A
                把entity的值赋给entityFull，第三个参数是忽略属性，表示不进行赋值
             */
            BeanUtils.copyProperties(entity, entityFull, ignoreProperties.toArray(new String[0]));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        E e = commonRepository.save(entityFull);
        return ResultGenerator.genSuccessResult(CopyUtil.copy(e, entityVoClass));
    }

    @Override
    public RestResult<T> delete(T id) {
        commonRepository.deleteById(id);
        return ResultGenerator.genSuccessResult(id);
    }
}
