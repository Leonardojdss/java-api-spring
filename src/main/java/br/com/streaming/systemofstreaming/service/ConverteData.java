package br.com.streaming.systemofstreaming.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.streaming.systemofstreaming.model.DataSerie;

public class ConverteData implements IconverteData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getdata(String json, Class<T> classType) {
        try {
        return mapper.readValue(json, classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JSON to object", e);
        }
    }
}