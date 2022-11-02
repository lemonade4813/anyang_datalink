package net.anyang.test.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.ApiInterface;
import net.anyang.test.service.common.GetDateService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class TaasService{
    @Autowired
    ApiInterface apiInterface;

    @Autowired
    GetDateService getDateService;

    public <T> T createObject(String jsonitem, Class<T> clazz){
        Gson gson = new Gson();
        return gson.fromJson(jsonitem, clazz);

    }

    public JsonObject getJsonResult(String url, String param) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if(param.length()==3) {
            sb.append("&").append("guGun").append("=").append(param);
        } else {
            sb.append("&").append("searchYearCd").append("=").append(param);
        }
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;

    }

    public JsonObject getJsonResult(String url, String searchYearCd, String guGun) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("searchYearCd").append("=").append(searchYearCd);
        sb.append("&").append("guGun").append("=").append(guGun);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;

    }

    public JsonArray getItems(JsonObject result) {
        return result.get("items").getAsJsonObject().get("item").getAsJsonArray();
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

