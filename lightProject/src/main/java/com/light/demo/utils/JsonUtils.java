package com.light.demo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sankuai.meituan.ccp.framework.core.utils.ExceptionPrintUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @author liwenhai
 */
public class JsonUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    private static Gson gson = new Gson();

    private static TypeReference<HashMap<String, String>> STRING_MAP_TYPE_REFERENCE = new TypeReference<HashMap<String, String>>() {
    };

    private JsonUtils() {
    }

    public static String toJsonString(Object object) {
        return gson.toJson(object);
    }

    public static <T> T parseJson(String source, Class<T> type) {
        return gson.fromJson(source, type);
    }

    /**
     * parseJson(mafkaMessageStr,  new TypeReference<PayResultDto<TPaymentResult>>(){});
     *
     * @param source
     * @param valueTypeRef
     * @return T
     * @author Li Ao (liao08@meituan.com)
     * @date 2020/6/11
     **/
    public static <T> T parseJson(String source, TypeReference<T> valueTypeRef) {
        return gson.fromJson(source, valueTypeRef.getType());
    }

    /**
     * 把string转换为数组
     *
     * @param s
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        T[] arr = gson.fromJson(s, clazz);
        return Arrays.asList(arr);
    }

    public static <T> T parseJson(String s, TypeToken type) {
        return gson.fromJson(s, type.getType());
    }

    /**
     * Returns the JSON object as a plain java object by the specified type.
     *
     * @param map  a Map representation of an object.
     * @param type the type of the desired object.
     * @return a plain java object by the specified type.
     */
    public static <T> T fromMap(Map<String, Object> map, Class<T> type) {
        return gson.fromJson(gson.toJson(map), type);
    }

    /**
     * Returns the JSON object as a plain java object by the specified type.
     */
    public static Map<String, Object> toMap(String src) {
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        return gson.fromJson(src, type);
    }

    /**
     * Return then JSON object as a plain java object by the specifed type with catching the exception
     * @param src
     * @return
     */
    public static Map<String,Object> toMapWithOutException(String src){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isBlank(src)){
            return map;
        }
        try{
            map=toMap(src);
        }catch (Exception e){
            LOGGER.warn("解析src为Map异常,src:{},e:{}",src, ExceptionPrintUtil.getStackTrace(e));
        }
        return map;
    }


    /**
     * 解析JsonObject中的key为 Integer
     */
    public static Integer getInteger(JsonObject jsonObject, String key) {
        if (Objects.isNull(jsonObject)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(key);
        if(jsonElement != null && !jsonElement.isJsonNull()){
            return jsonElement.getAsInt();
        }
        return null;
    }

    /**
     * 解析JsonObject中的key为 Long
     */
    public static Long getLong(JsonObject jsonObject, String key) {
        if (Objects.isNull(jsonObject)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(key);
        if(jsonElement != null && !jsonElement.isJsonNull()){
            return jsonElement.getAsLong();
        }
        return null;
    }

    /**
     * 解析JsonObject中的key为String
     */
    public static String getString(JsonObject jsonObject, String key) {
        if (Objects.isNull(jsonObject)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(key);
        if(jsonElement != null && !jsonElement.isJsonNull()){
            return jsonElement.getAsString();
        }
        return null;
    }

    /**
     * 解析JsonObject中的key为boolean
     */
    public static Boolean getBoolean(JsonObject jsonObject, String key) {
        if (Objects.isNull(jsonObject)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(key);
        if(jsonElement != null && !jsonElement.isJsonNull()){
            return jsonElement.getAsBoolean();
        }
        return null;
    }

}