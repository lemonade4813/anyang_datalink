package net.anyang.test.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.*;
import net.anyang.test.service.EpeopleService;
import net.anyang.test.service.common.CombineService;
import net.anyang.test.service.common.FindService;
import net.anyang.test.service.common.GetDateService;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;


@Slf4j
@RestController
@RequestMapping("/ps00016")
@CrossOrigin
@Configuration


public class EpeopleController extends CommonController{

    @Autowired
    ApiInterface apiInterface;
    @Autowired
    CombineService commonService;
    @Autowired
    EpeopleService epeopleService;
    @Autowired
    FindService findService;
    @Autowired
    GetDateService getDateService;


    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private String portNumber;

    final private String mainSubCode = "mainSubCode";
    final private String mainSubCodeVal = "3830000";

    /** 한눈에 보는 민원_오늘의 민원 이슈 정보_안양시 데이터 **/
    @GetMapping(value = "tdw_today_cvlcpt_issue", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_today_cvlcpt_issue(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        String paramNm = "searchDate";
        int clct_sn = 1;
        String date = epeopleService.getDate();
        JsonArray items = epeopleService.getJsonResultArr(tn_data_bass_info.getData_link_url(), paramNm, date);
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj =items.get(i).getAsJsonObject();
                epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                item = epeopleService.createObject(jsonObj.toString(), Tdw_today_cvlcpt_issue.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }


    /** 한눈에 보는 민원_민원발생 기관 순위_지방자치단체 데이터 **/
    @GetMapping(value = "tdw_cvlcpt_ocrn_inst_rank", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_cvlcpt_ocrn_inst_rank(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";
        String yesterDayBegin = epeopleService.getDate();
        String yesterDayEnd = epeopleService.getDate();
        JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, yesterDayBegin, dateTo, yesterDayEnd);
        int clct_sn = 1;
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj =items.get(i).getAsJsonObject();
                epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), null);
                item = epeopleService.createObject(jsonObj.toString(), Tdw_cvlcpt_ocrn_inst_rank.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }


    /** 한눈에 보는 민원_핵심 키워드 정보 **/
    @GetMapping(value = "tdw_core_kwrd_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_core_kwrd_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";
        String yesterDayBegin = epeopleService.getDate();
        String yesterDayEnd = epeopleService.getDate();
        int clct_sn = 1;
        JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, yesterDayBegin, dateTo, yesterDayEnd);
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj =items.get(i).getAsJsonObject();
                epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                item = epeopleService.createObject(jsonObj.toString(), Tdw_core_kwrd_info.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }


    /** 한눈에 보는 민원_민원발생 지역순위 **/
    @GetMapping(value = "tdw_cvlcpt_ocrn_area_rank", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_cvlcpt_ocrn_area_rank(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";
        String yesterDayBegin = epeopleService.getDate();
        String yesterDayEnd = epeopleService.getDate();
        JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, yesterDayBegin, dateTo, yesterDayEnd);
        int clct_sn = 1;
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj =items.get(i).getAsJsonObject();
                epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                item = epeopleService.createObject(jsonObj.toString(), Tdw_cvlcpt_ocrn_area_rank.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }


    /** 한눈의 보는 민원_키워드 기반 민원 건수 정보_안양시 데이터 **/
    @GetMapping(value = "tdw_kwrd_fnd_cvlcpt_nocs_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_kwrd_fnd_cvlcpt_nocs_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";
        String yesterDayBegin = epeopleService.getDate();
        String yesterDayEnd = epeopleService.getDate();
        JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, yesterDayBegin, dateTo, yesterDayEnd);
        int clct_sn = 1;
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj =items.get(i).getAsJsonObject();
                epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                jsonObj.addProperty("searchword","코로나");
                item = epeopleService.createObject(jsonObj.toString(), Tdw_kwrd_fnd_cvlcpt_nocs_info.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }


    /** 한눈의 보는 민원_지역 인구수 대비 민원현황 정보_안양시 데이터 **/
    @GetMapping(value = "tdw_area_popltn_provs_cvlcpt_sttus_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_area_popltn_provs_cvlcpt_sttus_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";
        String yesterDayBegin = epeopleService.getDate();
        String yesterDayEnd = epeopleService.getDate();
        JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, yesterDayBegin, dateTo, yesterDayEnd);
        int clct_sn = 1;
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj =items.get(i).getAsJsonObject();
                epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                item = epeopleService.createObject(jsonObj.toString(), Tdw_area_popltn_provs_cvlcpt_sttus_info.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }


    /** 한눈에 보는 민원_급증 키워드 정보_안양시 데이터 **/
    @GetMapping(value = "tdw_sdnincs_kwrd_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_sdnincs_kwrd_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String DataName = findService.findDateNm(dtst_sn);
        String date = epeopleService.getYesterdayHour();
        List<Object> classList = new ArrayList<>();
        Object item;
        JsonObject JsonResult = epeopleService.getJsonResultObj(tn_data_bass_info.getData_link_url(),DataName, date);
        JsonArray items = epeopleService.getItems(JsonResult);
        int clct_sn = 1;
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj =items.get(i).getAsJsonObject();
                epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                String jsonitem = jsonObj.toString().toLowerCase();
                item = epeopleService.createObject(jsonitem, Tdw_sdnincs_kwrd_info.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }

    /** 한눈의 보는 민원_최다 민원 키워드 정보_안양시 데이터 **/
    @GetMapping(value = "tdw_mxm_cvlcpt_kwrd_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_mxm_cvlcpt_kwrd_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String DataName = findService.findDateNm(dtst_sn);
        String date = epeopleService.getYesterdayHour();
        List<Object> classList = new ArrayList<>();
        Object item;
        JsonArray items = epeopleService.getJsonResultArr(tn_data_bass_info.getData_link_url(),DataName, date);
        int clct_sn = 1;
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj =items.get(i).getAsJsonObject();
                epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                item = epeopleService.createObject(jsonObj.toString(), Tdw_mxm_cvlcpt_kwrd_info.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }

    /** 한눈의 보는 민원_맞춤형 통계 정보_안양시 데이터 **/
    @GetMapping(value = "tdw_fixes_stats_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_fixes_stats_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
//        String DataName = findService.findDateNm(dtst_sn);
        String DataName1 = "dateFrom";
        String DataName2 = "dateTo";
        String date1 = epeopleService.getYesterdayBegin();
        String date2 = epeopleService.getYesterdayEnd();
        int clct_sn = 1;
        List<Object> classList = new ArrayList<>();
        Object item;
        JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url(),DataName1, date1, DataName2,date2);
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj =items.get(i).getAsJsonObject();
                epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                item = epeopleService.createObject(jsonObj.toString(), Tdw_fixes_stats_info.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }

    /** 한눈의 보는 민원_맞춤형 통계 정보_성별_안양시 데이터 **/
    @GetMapping(value = "tdw_fixes_stats_info_sexdstn", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_fixes_stats_info_sexdstn(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String date1 = epeopleService.getYesterdayBegin();
        String date2 = epeopleService.getYesterdayEnd();
        JsonArray params = findService.findParam(dtst_sn,"params");
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;

        for(int j = 0; j < params.size(); j++){
            String sex = params.get(j).toString();
            sex = sex.substring(0, sex.length()-1);
            sex = sex.substring(1);
            String URL = epeopleService.makeDayParameter(tn_data_bass_info.getData_link_url(),date1,date2,"sex",sex);
            JsonArray items = epeopleService.getJsonResult(URL).getAsJsonArray();
            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                    jsonObj.addProperty("sex",sex);
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_fixes_stats_info_sexdstn.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }
    
    /** 한눈의 보는 민원_맞춤형 통계 정보_연령_안양시 데이터 **/
    @GetMapping(value = "tdw_fixes_stats_info_agdstn", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_fixes_stats_info_agedstn(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String date1 = epeopleService.getYesterdayBegin();
        String date2 = epeopleService.getYesterdayEnd();
        JsonArray params = findService.findParam(dtst_sn,"params");
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;

        for(int j = 0; j < params.size(); j++){
            String age = params.get(j).toString();
            String URL = epeopleService.makeDayParameter(tn_data_bass_info.getData_link_url(),date1,date2,"age",age);
            JsonArray items = epeopleService.getJsonResult(URL).getAsJsonArray();
            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(), mainSubCodeVal);
                    jsonObj.addProperty("age",age);
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_fixes_stats_info_agdstn.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }


    @Override
    @GetMapping(value = "/common",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> common(@RequestParam(value="dtst_sn") Long dtst_sn) throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String tb_nm = tn_data_bass_info.getInnerClctTblPhysiclNm();
        String packageName = this.getClass().getPackage().getName();
        String className = commonService.makeClassName(packageName,tb_nm);
        Class clazz = Class.forName(className);
        List<Object> classList = new ArrayList<>();
        String pgng_yn = tn_data_bass_info.getPgng_yn();
        String pvsnInstNm = tn_data_bass_info.getPvsn_site_cd();

        if (pgng_yn.equals("Y")) {
            int offset = 1;
            int count = 0;
            String page = "pageNo";
            String perPage = "numofRows";
            while(true) {
                JsonObject result = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url(),page,perPage,offset);
                int totalcount = epeopleService.getTotal(result);
                JsonArray items = epeopleService.getItems(result);

                if(items.size() > 0){
                    for(int j=0; j < items.size(); j++ ){
                        Object resultObject = epeopleService.createObject(items.get(j).getAsJsonObject().toString(),clazz);
                        classList.add(resultObject);
                        count ++;
                    }
                }
                if(count == totalcount){
                    log.info("total : " + totalcount);
                    break;
                }
                else {
                    offset ++;
                }
            }
        }
        else {
            String url = commonService.makeUrl(pvsnInstNm,tb_nm,host,portNumber);
            ResponseBody responseBody = apiInterface.getUrl(url,dtst_sn).execute().body();
            classList = commonService.makeLists(responseBody.string());
            return classList;
        }
        return classList;
    }

    /*********************************************************************************************************/


    /** 한눈에 보는 민원_오늘의 민원 이슈 정보_안양시 기초데이터 / dtst_sn : 180 **/
    @GetMapping(value = "download01", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_today_cvlcpt_issue_init(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                    @RequestParam(value = "startDate") String startDate,
                                                    @RequestParam (value = "endDate" ) int endDate)throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;
        String paramNm = "searchDate";

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();

        String initDate = startDate;
        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);

        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate){
            startDate =  epeopleService.getDateByString(startDt.getTime());
            JsonArray items = epeopleService.getJsonResultArr(tn_data_bass_info.getData_link_url(), paramNm, startDate);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_today_cvlcpt_issue.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_today_cvlcpt_issue";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }


    /** 한눈에 보는 민원_민원발생 기관 순위_지방자치단체 데이터 초기데이터 / dtst_sn : 181 **/
    @GetMapping(value = "download02", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_cvlcpt_ocrn_inst_rank(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                  @RequestParam(value = "startDate") String startDate,
                                                  @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();
        String initDate = startDate;
        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);


        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate){
            startDate =  epeopleService.getDateByString(startDt.getTime());
            JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, startDate, dateTo, startDate);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_cvlcpt_ocrn_inst_rank.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_cvlcpt_ocrn_inst_rank";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }

    /** 한눈에 보는 민원_급증 키워드 정보_안양시 초기데이터 / dtst_sn : 182 **/
    @GetMapping(value = "download03", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_sdnincs_kwrd_info_init(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                   @RequestParam(value = "startDate") String startDate,
                                                   @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;
        String paramNm = "analysisTime";
        String initDate = startDate;

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();;
        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);

        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate){
            startDate =  epeopleService.getDateByString(startDt.getTime());
            String startDateHour = startDate + "23";
            JsonObject JsonResult = epeopleService.getJsonResultObj(tn_data_bass_info.getData_link_url(), paramNm, startDateHour);
            JsonArray items = epeopleService.getItems(JsonResult);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                    item = epeopleService.createObject(jsonObj.toString().toLowerCase(), Tdw_sdnincs_kwrd_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_sdnincs_kwrd_info";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        System.out.println(classList);
        return classList;
    }

    /** 한눈에 보는 민원_핵심 키워드 정보_안양시 데이터 초기데이터 / dtst_sn : 183 **/
    @GetMapping(value = "download04", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_core_kwrd_info_init(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                @RequestParam(value = "startDate") String startDate,
                                                @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();

        String initDate = startDate;
        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);

        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate){
            startDate =  epeopleService.getDateByString(startDt.getTime());
            JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, startDate, dateTo, startDate);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_core_kwrd_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_core_kwrd_info";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }


    /** 한눈에 보는 민원_민원발생 지역순위_안양시 초기데이터 / dtst_sn : 184 **/
    @GetMapping(value = "download05", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_cvlcpt_ocrn_area_rank_init(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                       @RequestParam(value = "startDate") String startDate,
                                                       @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();

        String initDate = startDate;

        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);

        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate){
            startDate =  epeopleService.getDateByString(startDt.getTime());
            JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, startDate, dateTo, startDate);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_cvlcpt_ocrn_area_rank.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_cvlcpt_ocrn_area_rank";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }


    /** 한눈에 보는 민원_키워드 기반 민원 건수 정보_안양시 초기데이터 /dtst_sn : 185 **/
    @GetMapping(value = "download06", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_kwrd_fnd_cvlcpt_nocs_info_init(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                           @RequestParam(value = "startDate") String startDate,
                                                           @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();

        String initDate = startDate;

        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);

        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate){
            startDate =  epeopleService.getDateByString(startDt.getTime());
            JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, startDate, dateTo, startDate);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                    jsonObj.addProperty("searchword","코로나");
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_kwrd_fnd_cvlcpt_nocs_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_kwrd_fnd_cvlcpt_nocs_info";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }


    /** 한눈의 보는 민원_맞춤형 통계 정보_안양시 초기데이터 dtst_sn : 186 **/
    @GetMapping(value = "download07", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_fixes_stats_info_init(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                  @RequestParam(value = "startDate") String startDate,
                                                  @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();

        String initDate = startDate;
        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);


        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate){
            startDate =  epeopleService.getDateByString(startDt.getTime());
            String startDateBegin = startDate + "000000";
            String endDateBegin = startDate + "235959";
            JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, startDateBegin, dateTo, endDateBegin);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_fixes_stats_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_fixes_stats_info";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }


    /** 한눈의 보는 민원_맞춤형 통계 정보_성별_안양시 초기데이터 dtst_sn : 187 **/
    @GetMapping(value = "download08", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_fixes_stats_info_sexdstn_init(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                          @RequestParam(value = "startDate") String startDate,
                                                          @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;

        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);
        JsonArray params = findService.findParam(dtst_sn,"params");

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();

        String initDate = startDate;


        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate) {
            startDate = epeopleService.getDateByString(startDt.getTime());
            String startDateBegin = startDate + "000000";
            String endDateBegin = startDate + "235959";
            for (int j = 0; j < params.size(); j++) {
                String sex = params.get(j).toString();
                sex = sex.substring(0, sex.length() - 1);
                sex = sex.substring(1);
                String URL = epeopleService.makeDayParameter(tn_data_bass_info.getData_link_url(), startDateBegin, endDateBegin, "sex", sex);
                JsonArray items = epeopleService.getJsonResult(URL).getAsJsonArray();
                if (items.size() > 0) {
                    for (int i = 0; i < items.size(); i++) {
                        JsonObject jsonObj = items.get(i).getAsJsonObject();
                        epeopleService.appendColumInit(jsonObj, j+1, startDate, mainSubCodeVal);
                        jsonObj.addProperty("sex",sex);
                        item = epeopleService.createObject(jsonObj.toString(), Tdw_fixes_stats_info_sexdstn.class);
                        classList.add(item);
                        }
                    }
                }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_fixes_stats_info_sexdstn";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }

    /** 한눈의 보는 민원_맞춤형통계 정보_연령별 기초데이터  dtst_sn : 188 **/
    @GetMapping(value = "download09", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_fixes_stats_info_agdstn_init(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                         @RequestParam(value = "startDate") String startDate,
                                                         @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;

        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);
        JsonArray params = findService.findParam(dtst_sn,"params");

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();

        String initDate = startDate;

        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate) {
            startDate = epeopleService.getDateByString(startDt.getTime());
            String startDateBegin = startDate + "000000";
            String endDateBegin = startDate + "235959";
            int clct_sn = 0;
            for (int j = 0; j < params.size(); j++) {
                String age = params.get(j).toString();
                String URL = epeopleService.makeDayParameter(tn_data_bass_info.getData_link_url(), startDateBegin, endDateBegin, "age", age);
                JsonArray items = epeopleService.getJsonResult(URL).getAsJsonArray();
                if(items.size() !=0 ) {
                    clct_sn++;
                }
                if (items.size() > 0) {
                    for (int i = 0; i < items.size(); i++) {
                        JsonObject jsonObj = items.get(i).getAsJsonObject();
                             {
                                epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                                jsonObj.addProperty("age", age);
                                item = epeopleService.createObject(jsonObj.toString(), Tdw_fixes_stats_info_agdstn.class);
                                classList.add(item);
                            }
                    }
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_fixes_stats_info_agdstn";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }

    /** 한눈에 보는 민원_지역 인구수 대비 민원현황 정보 데이터 기초데이터 dtst_sn : 189 **/
    @GetMapping(value = "download10", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_area_popltn_provs_cvlcpt_sttus_info(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                                @RequestParam(value = "startDate") String startDate,
                                                                @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;
        String dateFrom = "dateFrom";
        String dateTo = "dateTo";

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();

        String initDate = startDate;

        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);

        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate){
            startDate =  epeopleService.getDateByString(startDt.getTime());
            JsonArray items = epeopleService.getJsonResult(tn_data_bass_info.getData_link_url() ,dateFrom, startDate, dateTo, startDate);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_area_popltn_provs_cvlcpt_sttus_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_area_popltn_provs_cvlcpt_sttus_info";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }

    /** 한눈에 보는 민원_오늘의 민원 이슈 정보_안양시 기초데이터 dtst_sn : 190 **/
    @GetMapping(value = "download11", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_mxm_cvlcpt_kwrd_info_init(@RequestParam(value = "dtst_sn") Long dtst_sn ,
                                                      @RequestParam(value = "startDate") String startDate,
                                                      @RequestParam (value = "endDate" ) int endDate) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        System.out.println(tn_data_bass_info.getData_link_url());
        List<Object> classList = new ArrayList<>();

        Object item;
        String paramNm = "analysisTime";

        //endDate 대신 현재 날짜로 파라미터 설정할 경우 사용
        //int nowday = getDateService.getNowDayInt();

        String initDate = startDate;

        Calendar startDt =  epeopleService.startDateyyyyMMdd(startDate);

        while (epeopleService.getDateByInteger(startDt.getTime()) <= endDate){
            startDate =  epeopleService.getDateByString(startDt.getTime());
            JsonArray items = epeopleService.getJsonResultArr(tn_data_bass_info.getData_link_url(), paramNm, startDate);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    System.out.println("jsonObj  : " +  jsonObj);
                    epeopleService.appendColumInit(jsonObj, clct_sn, startDate, mainSubCodeVal);
                    item = epeopleService.createObject(jsonObj.toString(), Tdw_mxm_cvlcpt_kwrd_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            startDt.add(Calendar.DATE, 1);
        }

        String fileNm = "tdw_mxm_cvlcpt_kwrd_info";
        String filePath = epeopleService.initFilePath(fileNm,initDate,Integer.toString(endDate));
        epeopleService.fileWrite(filePath, classList);
        return classList;
    }


}
