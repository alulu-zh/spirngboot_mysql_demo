package com.mypro2020.demo.springboot.mysql_demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class JsonUtils {
    public static final ObjectMapper SNAKE_MAPPER = new ObjectMapper();
    public static final ObjectMapper CAMEL_MAPPER = new ObjectMapper();
    public static final ObjectMapper DEFAULT_MAPPER = SNAKE_MAPPER;

    private JsonUtils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    static {
        SNAKE_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        SNAKE_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SNAKE_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        CAMEL_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        CAMEL_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CAMEL_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public static <T> T unmarshal(String jsonString, Class<T> clazz) throws JsonProcessingException {
        if (jsonString == null) {
            return null;
        }
        return DEFAULT_MAPPER.readValue(jsonString, clazz);
    }

    public static String marshal(Object object) throws JsonProcessingException {
        return DEFAULT_MAPPER.writeValueAsString(object);
    }

    public static <T> T unmarshal(String jsonString, Class<T> clazz, boolean isSnakeMapper) throws JsonProcessingException {
        if (jsonString == null) {
            return null;
        }
        ObjectMapper mapper = CAMEL_MAPPER;
        if (isSnakeMapper) {
            mapper = SNAKE_MAPPER;
        }
        return mapper.readValue(jsonString, clazz);
    }

    public static String marshal(Object object, boolean isSnakeMapper) throws JsonProcessingException {
        ObjectMapper mapper = CAMEL_MAPPER;
        if (isSnakeMapper) {
            mapper = SNAKE_MAPPER;
        }
        return mapper.writeValueAsString(object);
    }

}
