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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Slf4j
@Service
public class WeatherService {
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

    public JsonObject getJsonResult(String url, String yesterday) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("startDt").append("=").append(yesterday);
        sb.append("&").append("endDt").append("=").append(yesterday);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }

    public JsonObject getJsonResult(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("base_date").append("=").append(getDateService.getNowDay());
        sb.append("&").append("base_time").append("=").append(getDateService.getNowTime());
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }

    public int getTotal(JsonObject result) {
        return result.get("response").getAsJsonObject().get("body").getAsJsonObject().get("totalCount").getAsInt();
    }

    public JsonArray getItems(JsonObject result) {
        return result.get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonObject().get("item").getAsJsonArray();
    }

    public String getYesterday() {
        LocalDate now = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(formatter);
    }

    public JsonObject appendColum(JsonObject jsonObj, Integer clct_sn, String dataUpdtCycle) throws IOException{
        jsonObj.addProperty("clct_sn",clct_sn);
        jsonObj.addProperty("clct_dt",getDateService.getNowDay());
        if(dataUpdtCycle.equals("day")){
            jsonObj.addProperty("data_crtr_pnttm",getDateService.getYesterday());
        }else if(dataUpdtCycle.equals("month")){
            jsonObj.addProperty("data_crtr_pnttm",getDateService.getBeforeMonth());
        }
        return jsonObj;
    }

    public <T> T createObject(String jsonitem, Class<T> clazz){
        return new Gson().fromJson(jsonitem,clazz);
    }
}
