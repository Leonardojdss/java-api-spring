package br.com.streaming.systemofstreaming.service;

public interface IconverteData {
    <T> T getdata(String json, Class<T> classType);
}
