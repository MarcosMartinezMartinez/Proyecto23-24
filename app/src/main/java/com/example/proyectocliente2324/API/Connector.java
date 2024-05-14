package com.example.proyectocliente2324.API;


import com.example.proyectocliente2324.base.Parameters;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;


public class Connector {

    private static Connector connector;
    private static Conversor conversor;
    private static CallMethods callMethodsObject;

    public static Connector getConector(){
        if(connector == null){
            connector = new Connector();
            conversor = Conversor.getConversor();
            callMethodsObject = CallMethods.getCallMethodsObject();
        }
        return connector;
    }

    public <T> List<T> getAsList(Class<T> clazz, String path){
        String url = Parameters.URL + Parameters.URL_OPTIONS + path;
        String jsonResponse = callMethodsObject.get(url);
        if(jsonResponse != null)
            return conversor.fromJsonList(jsonResponse, clazz);
        return null;
    }


    public <T> T get(Class<T> clazz, String path){
        String url = Parameters.URL + Parameters.URL_OPTIONS + path;
        String jsonResponse = callMethodsObject.get(url);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    public <T> T post(Class<T> clazz, T data, String path){
        String url = Parameters.URL + Parameters.URL_OPTIONS + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.post(url, body);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    public <T> T put(Class<T> clazz, T data, String path){
        String url = Parameters.URL + Parameters.URL_OPTIONS + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.put(url, body);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    public <T> T delete(Class<T> clazz, String path){
        String url = Parameters.URL + Parameters.URL_OPTIONS + path;
        String jsonResponse = callMethodsObject.delete(url);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

}

