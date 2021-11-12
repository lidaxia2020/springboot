package com.lidaxia.common.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/12 10:51（
 */
public class ToTreeUtil<T, K> {

    private List<T> list;
    private Function<? super T, ? extends K> getId;
    private Function<? super T, ? extends K> getParentId;
    private Consumer<T> setChildren;
    private FloorConsumer<T, ? extends Integer> setFloor;

    /**
     * 这个是不用楼数的
     *
     * @param list        需要转换的list数据
     * @param getId       节点的id
     * @param getParentId 节点的父id
     * @param setChildren 注入子节点的方法
     */
    public ToTreeUtil(List<T> list,
                      Function<? super T, ? extends K> getId,
                      Function<? super T, ? extends K> getParentId,
                      Consumer<T> setChildren) {
        this.list = list;
        this.getId = getId;
        this.getParentId = getParentId;
        this.setChildren = setChildren;
    }

    /**
     * 这个是使用楼数的
     *
     * @param list        需要转换的list数据
     * @param getId       节点的id
     * @param getParentId 节点的父id
     * @param setChildren 注入子节点的方法
     * @param setFloor    注入当前节点处于整棵树层数的方法
     */
    public ToTreeUtil(List<T> list,
                      Function<? super T, ? extends K> getId,
                      Function<? super T, ? extends K> getParentId,
                      Consumer<T> setChildren,
                      FloorConsumer<T, ? extends Integer> setFloor) {
        this.list = list;
        this.getId = getId;
        this.getParentId = getParentId;
        this.setChildren = setChildren;
        this.setFloor = setFloor;
    }

    /**
     * 开始构建节点
     *
     * @return list 所有根节点的集合
     */
    public List<T> build() {
        if (this.list.isEmpty()) {
            throw new NullPointerException();
        }
        List<T> rootList = new ArrayList<>();
        //假设里面的每个元素都是根节点
        for (T root : this.list) {
            //如果自己的id在所有元素的parentId中都不存在，则可以认定该元素是一个根节点
            if (this.list.stream().noneMatch(item -> getId.apply(item).equals(getParentId.apply(root)))) {
                rootList.add(buildChild(root, 1));
            }
        }
        return rootList;
    }

    /**
     * 使用递归开始构建子节点
     *
     * @param parent 父节点
     * @param floor  层数
     * @return T 构建好当前节点的所有子节点
     */
    private T buildChild(T parent, int floor) {
        List<T> children = new ArrayList<>();
        if (setFloor != null) {
            setFloor.accept(parent, floor);
        }
        for (T t : list) {
            if (getId.apply(parent).equals(getParentId.apply(t))) {
                children.add(buildChild(t, (floor + 1)));
            }
        }
        // 找到所有子节点后将其注入到父节点
        if (!children.isEmpty()) {
            setChildren.accept(parent, children);
        }

        return parent;
    }
}
