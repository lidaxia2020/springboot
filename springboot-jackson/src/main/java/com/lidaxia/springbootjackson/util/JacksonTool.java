package com.lidaxia.springbootjackson.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lidaxia.springbootjackson.vo.UserVoByJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 11:57（
 */
public class JacksonTool {


    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonTool.class);

    private final static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        // 忽略json中在对象不存在对应属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 忽略空bean转json错误
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //当属性的值为空（null或者""）时，不进行序列化，可以减少数据传输
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    /**
     * json转对象
     *
     * @param jsonStr   json串
     * @param classType 对象类型
     * @return 对象
     */
    public static <T> T toEntity(String jsonStr, Class<T> classType) {

        if (StringUtils.isEmpty(jsonStr)) {
            LOGGER.warn("Json string {} is empty!", classType);
            return null;
        }

        try {
            return mapper.readValue(jsonStr, classType);
        } catch (IOException e) {
            LOGGER.error("json to entity error.", e);
        }
        return null;
    }

    public static <T> T convertValue(Object fromValue, Class<T> toValueType)  {
        try {
            return mapper.convertValue(fromValue, toValueType);
        }catch (IllegalArgumentException e){
            LOGGER.error("json convertValue error.", e);
        }
        return null;
    }

    /**
     * json转化为带泛型的对象
     *
     * @param jsonStr json字符串
     * @param typeReference 转化类型
     * @return 对象
     */
    public static <T> T toEntity(String jsonStr, TypeReference<T> typeReference){
        if (StringUtils.isBlank(jsonStr) || typeReference == null) {
            return null;
        }
        try {
            return (T) mapper.readValue(jsonStr, typeReference);
        } catch (JsonProcessingException e) {
            LOGGER.error("json to entity error.", e);
        }catch (IOException e){
            LOGGER.error("json to entity error.", e);
        }
        return null;
    }

    /**
     * 对象转json
     *
     * @param obj 对象
     * @return json串
     */
    public static String toJson(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException e) {
            LOGGER.error("obj to json error.", e);
        }
        return null;
    }

    /**
     * 对象转json(格式化的json)
     *
     * @param obj 对象
     * @return 格式化的json串
     */
    public static String toJsonWithFormat(Object obj) {
        if (obj == null) {
            return null;
        }

        if (obj instanceof String) {
            return (String) obj;
        }

        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            LOGGER.error("obj to json error.", e);
        }
        return null;
    }


}
