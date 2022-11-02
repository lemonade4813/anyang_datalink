package net.anyang.test.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.ApiInterface;
import net.anyang.test.service.common.GetDateService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class DataGovService implements CommonInterface{

    @Autowired
    ApiInterface apiInterface;

    @Autowired
    GetDateService getDateService;

    @Override
    public <T> T createObject(String jsonitem, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonitem, clazz);
    }

    @Override
    public JsonObject getJsonResult(String url, String page, String perPage, int offset) throws IOException {
        return null;
    }


    public JsonObject getJsonResult(String url, String page, String perPage, int offset, String param) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append(perPage).append("=").append("1000");
        sb.append("&").append(page).append("=").append(offset);
        sb.append("&").append("key").append("=").append(param);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonObject;
    }


    @Override
    public JsonObject getJsonResult(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }

    public JsonObject getJsonResult(String url,String param) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("pnu").append("=").append(param);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }


    @Override
    public int getTotal(JsonObject result) {
        return result.get("body").getAsJsonObject().get("totalCount").getAsInt();
        // return 0;
    }

    @Override
    public int getTotal(JsonObject result, String jsonDivide) {
        return 0;
    }

    @Override
    public JsonArray getItems(JsonObject result, String jsonDivide) {
        return null;
    }


    public JsonArray getItems(JsonObject result) {
        return result.get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonArray();
    }

    public JsonArray getItems(JsonObject result, String jsonDivide,String item) {
        return result.get(jsonDivide).getAsJsonObject().get(item).getAsJsonArray();
    }

    public String makeYearParameter(String url, String Year) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("year").append("=").append(Year);
        return sb.toString();
    }

    public String makeDayParameter(String url, String date) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("date").append("=").append(date);
        return sb.toString();
    }

    public JsonObject appendColum(JsonObject jsonObj, Integer clct_sn, String dataUpdtCycle) throws IOException{
        jsonObj.addProperty("clct_sn",clct_sn);
        jsonObj.addProperty("clct_dt",getDateService.getNowDay());
        if(dataUpdtCycle.equals("day")){
            jsonObj.addProperty("data_crtr_pnttm", getDateService.getYesterday());
        }else if(dataUpdtCycle.equals("month")){
            jsonObj.addProperty("data_crtr_pnttm",getDateService.getBeforeMonth());
        }
        return jsonObj;
    }

}
