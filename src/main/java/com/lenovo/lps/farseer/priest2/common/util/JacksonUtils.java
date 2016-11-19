package com.lenovo.lps.farseer.priest2.common.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;

/**
 * JSON格式数据转换工具类.
 * 
 * @author liyi7
 */
public final class JacksonUtils {

    private static Logger logger = Logger.getLogger(JacksonUtils.class);
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T parseData(String json, Class<T> vClass) {
        T object = null;
        try {
            if (json != null && json.length() > 0) {
                object = mapper.readValue(json, vClass);
            }
        } catch (JsonParseException e) {
            logger.error("Parse JSON Data error. JSONString = " + json, e);
        } catch (JsonMappingException e) {
            logger.error("can't parse the order data type when parsing JSON Data.JSONString = " + json, e);
        } catch (IOException e) {
            logger.error("IOException when parsing JSON Data.JSONString = " + json, e);
        }
        return object;
    }

    public static String writeJson(Object object) {
        String result = null;
        try {
            if (object != null) {
                result = mapper.writeValueAsString(object);
            }
        } catch (JsonGenerationException e) {
            logger.error("Transform to JSON error.", e);
        } catch (JsonMappingException e) {
            logger.error("can't parse the order data type when transforming to JSON.", e);
        } catch (IOException e) {
            logger.error("IOException when transforming to JSON.", e);
        }
        return result;
    }

    private JacksonUtils() {
    }
}
