package com.java.consumer.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
    private Mapper() {
    }

    public static ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
