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

@Slf4j
@Service
public class FinDataMallServiceImpl implements FinDataMallService {
    @Autowired
    ApiInterface apiInterface;
    @Autowired
    GetDateService getDateService;

    @Override
    public <T> T createObject(String jsonitem, Class<T> clazz) {
        return new Gson().fromJson(jsonitem,clazz);
    }

    @Override
    public JsonObject getJsonResult(String url, String page, String perPage, int offset) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append(page).append("=").append(offset);
        sb.append("&").append(perPage).append("=").append("1000");
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
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
    @Override
    public int getTotal(JsonObject result,String jsonDivide) {
        return result.get(jsonDivide).getAsJsonArray().get(0).getAsJsonObject().get("head").getAsJsonArray().get(0).getAsJsonObject().get("list_total_count").getAsInt();
    }
    @Override
    public JsonArray getItems(JsonObject result, String jsonDivide) {
        return result.get(jsonDivide).getAsJsonArray().get(1).getAsJsonObject().get("row").getAsJsonArray();
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
}
