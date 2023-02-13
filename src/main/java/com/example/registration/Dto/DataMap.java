package com.example.registration.Dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class DataMap<T> {
    private T data;

    public DataMap(T data){
        this.data = data;
    }
    public Map get() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(mapper.writeValueAsString(data), Map.class);

    }
}
