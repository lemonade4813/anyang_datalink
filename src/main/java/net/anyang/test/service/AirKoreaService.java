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

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Slf4j
@Service
public class AirKoreaService{
    @Autowired
    ApiInterface apiInterface;
    @Autowired
    GetDateService getDateService;

    public JsonObject getJsonResult(String url,String page,String perPage,int offset) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append(page).append("=").append(offset);
        sb.append("&").append(perPage).append("=").append("10");
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;

    }
    public JsonObject getJsonResult(String url, String param) throws IOException {
        StringBuilder sb = new StringBuilder();
        String encode = URLEncoder.encode(param, "UTF-8");
        sb.append(url);
        sb.append("&").append("stationName").append("=").append(encode);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }

    public JsonObject getJsonResult(String url, String paramNm, String param) throws IOException {
        StringBuilder sb = new StringBuilder();
        String encode = URLEncoder.encode(param, "UTF-8");
        sb.append(url);
        sb.append("&").append(paramNm).append("=").append(encode);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }

    public JsonObject getJsonResult(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;

    }

    public JsonObject appendColum(JsonObject jsonObj, Integer clct_sn, String dataUpdtCycle,@Nullable String OptionalParameter) throws IOException{
        jsonObj.addProperty("clct_sn",clct_sn);
        jsonObj.addProperty("clct_dt",getDateService.getNowDay());
        if(dataUpdtCycle.equals("day")){
            jsonObj.addProperty("data_crtr_pnttm",getDateService.getYesterday());
        }else if(dataUpdtCycle.equals("month")){
            jsonObj.addProperty("data_crtr_pnttm",getDateService.getBeforeMonth());
        }
        if(OptionalParameter != null){
            jsonObj.addProperty("stationName",OptionalParameter);
        }
     return jsonObj;
    }

    public int getTotal(JsonObject result) {
        return result.get("response").getAsJsonObject().get("body").getAsJsonObject().get("totalCount").getAsInt();
    }

     public JsonArray getItems(JsonObject result) {
        return result.get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonArray();
    }

    public String makeDayParameter(String url,String inqBginDt, String inqEndDt) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("inqBginDt").append("=").append(inqBginDt);
        sb.append("&").append("inqEndDt").append("=").append(inqEndDt);
        return sb.toString();
    }

    public String makeMonthParameter(String url, String inqBginMm, String inqEndMm) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("inqBginMm").append("=").append(inqBginMm);
        sb.append("&").append("inqEndMm").append("=").append(inqEndMm);
        return sb.toString();
    }

    public String getBeforeMonth() {
        LocalDate now = LocalDate.now().minusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        return now.format(formatter);
    }

    public String getYesterday() {
        LocalDate now = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(formatter);
    }

    public String getNowMonth() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        return now.format(formatter);
    }

    public String getNowDay() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(formatter);
    }

    public <T> T createObject(String jsonitem, Class<T> clazz){
        return new Gson().fromJson(jsonitem,clazz);
    }
}
