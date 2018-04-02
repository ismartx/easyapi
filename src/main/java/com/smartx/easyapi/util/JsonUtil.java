package com.smartx.easyapi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * <b>Creation Time:</b> 2017/11/15
 *
 * @author kext
 */
@Slf4j
public final class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static String object2Json(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    public static <T> T json2Object(String str, Class<T> clazz) throws IOException {
        return mapper.readValue(str, clazz);
    }

}
