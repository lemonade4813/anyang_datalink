package net.anyang.test.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.io.IOException;


public interface DatadreamService {
    public <T> T createObject(String jsonitem, Class<T> clazz);
    public JsonObject getJsonResult(String url, String page, String perPage, int offset) throws IOException;
    public JsonObject getJsonResult(String url) throws IOException;
    public int getTotal(JsonObject result, String jsonDivide);
    public JsonArray getItems(JsonObject result, String jsonDivide);
    public JsonObject appendColum(JsonObject jsonObj, Integer clct_sn, String dataUpdtCycle,@Nullable String OptionalParameter) throws IOException;
}
