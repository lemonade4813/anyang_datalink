package net.anyang.test.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.List;

interface CommonInterface {

    //public List<Object> common();

    public <T> T createObject(String jsonitem, Class<T> clazz);
    public JsonObject getJsonResult(String url,String page,String perPage,int offset) throws IOException;
    public JsonObject getJsonResult(String url) throws IOException;
    public int getTotal(JsonObject result);
    public int getTotal(JsonObject result,String jsonDivide);
    public JsonArray getItems(JsonObject result, String jsonDivide);


}
