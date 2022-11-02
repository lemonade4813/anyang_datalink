package net.anyang.test.service;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.ApiInterface;
import net.anyang.test.service.common.GetDateService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.http.OPTIONS;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Service
public class EpeopleService{


    @Autowired
    ApiInterface apiInterface;
    @Autowired
    GetDateService getDateService;

    public JsonObject getJsonResult(String url, String page, String perPage, int offset) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }

    public JsonArray getJsonResult(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonArray jsonResult = new JsonParser().parse(jsonString).getAsJsonArray();
        return jsonResult;
    }

    public JsonArray getJsonResult(String url, String paramNm1, String paramValue1, String paramNm2, String paramValue2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append(paramNm1).append("=").append(paramValue1);
        sb.append("&").append(paramNm2).append("=").append(paramValue2);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        //JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        JsonArray jsonResult = new JsonParser().parse(jsonString).getAsJsonArray();
        return jsonResult;
    }

    public JsonObject getJsonResultObj(String url, String dateName, String dateVal) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append(dateName).append("=").append(dateVal);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        //JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonResult;
    }

    public JsonArray getJsonResultArr(String url, String dateName, String dateVal) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append(dateName).append("=").append(dateVal);
        log.info(sb.toString());
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        //JsonObject jsonResult = new JsonParser().parse(jsonString).getAsJsonObject();
        JsonArray jsonResult = new JsonParser().parse(jsonString).getAsJsonArray();
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
            jsonObj.addProperty("mainsubcode",OptionalParameter);
        }
        return jsonObj;
    }

    public JsonObject appendColumInit(JsonObject jsonObj, Integer clct_sn, String date,@Nullable String OptionalParameter) throws IOException{
        jsonObj.addProperty("clct_sn",clct_sn);
        jsonObj.addProperty("clct_dt",getDateService.getNowDay());
        jsonObj.addProperty("data_crtr_pnttm",date);
        if(OptionalParameter != null){
            jsonObj.addProperty("mainsubcode",OptionalParameter);
        }
        return jsonObj;
    }

    public String getDate() {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE , -1);
        String beforeDate = new java.text.SimpleDateFormat("yyyyMMdd").format(day.getTime());
        return beforeDate;
    }


    public int getTotal(JsonObject result) {
        return result.get("totalCount").getAsInt();
    }

    public int getTotal(JsonObject result, String jsonDivide) {
        return 0;
    }

    public JsonArray getItems(JsonObject result, String jsonDivide) {
        return result.get("items").getAsJsonObject().get("item").getAsJsonArray();
    }

    public JsonArray getItems(JsonObject result) {
        return result.get("returnObject").getAsJsonArray();
    }



    public <T> T createObject(String jsonitem, Class<T> clazz){
        Gson gson = new Gson();
        return gson.fromJson(jsonitem, clazz);

    }

    public String makeUrl(String tb_nm, String ip,String port) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ip).append(":").append(port).append("/taas/").append(tb_nm);
        return stringBuilder.toString();
    }

    public List<Object> makeLists(String bodyJsonString) {
        Type listType = new TypeToken<List<Object>>(){}.getType();
        Gson gson = new Gson();
        List<Object> lists = gson.fromJson(bodyJsonString,listType);
        return lists;
    }

    public String makeClassName(String packageName,String tb_nm) {
        String[] packageArray = packageName.split("\\.");
        ArrayList<String> packageList = new ArrayList<>(Arrays.asList(packageArray));
        packageList.remove(packageList.size()-1);
        packageName = String.join(".",packageList);
        tb_nm = tb_nm.substring(0, 1).toUpperCase() + tb_nm.substring(1).toLowerCase();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageName).append(".model.").append(tb_nm);

        return stringBuilder.toString();
    }

    public String makeDayParameter(String url,String dateFrom, String dateTo,String paramNm, String paramVal) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("&").append("dateFrom").append("=").append(dateFrom);
        sb.append("&").append("dateTo").append("=").append(dateTo);
        sb.append("&").append(paramNm).append("=").append(paramVal);
        return sb.toString();
    }


    public String getYesterdayBegin() {
        LocalDate now = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        StringBuilder sb = new StringBuilder();
        return sb.append(now.format(formatter).toString()).append("000000").toString();
    }
    public String getYesterdayEnd() {
        LocalDate now = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        StringBuilder sb = new StringBuilder();
        return sb.append(now.format(formatter).toString()).append("235959").toString();
    }
    public String getYesterdayHour() {
        LocalDate now = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        StringBuilder sb = new StringBuilder();
        return sb.append(now.format(formatter).toString()).append("23").toString();
    }

    // String을 Date로 변환

    public Calendar startDateyyyyMMdd(String startDt){

        int startYear = Integer.parseInt(startDt.substring(0,4));
        int startMonth= Integer.parseInt(startDt.substring(4,6));
        int startDate = Integer.parseInt(startDt.substring(6,8));

        Calendar cal = Calendar.getInstance();
        cal.set(startYear, startMonth -1, startDate);

        return cal;
    }

    //Date를 int로 변환

    public static int getDateByInteger(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt(sdf.format(date));
    }

    //Date를 String으로 변환
    public static String getDateByString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public String initFilePath(String initFileName, String startDate, String endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("/home/datanuri/initdata/json/").append(startDate).append("_").append(endDate).append("/");

        File Folder = new File(sb.toString());

        if(!Folder.exists()){
            try{
                Folder.mkdirs();
            }
            catch (Exception e){
                e.getStackTrace();
            }
        }

        sb.append(initFileName).append(".json");
        log.info(sb.toString());
        return sb.toString();
    }

    public void fileWrite(String filePath , List<Object> classList) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = new FileWriter(filePath);
        file.write(gson.toJson(classList));
        file.flush();
        file.close();
    }

}
