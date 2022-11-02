package net.anyang.test.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.*;
import net.anyang.test.service.common.CombineService;
import net.anyang.test.service.common.FindService;
import net.anyang.test.service.DataGovService;
import net.anyang.test.service.common.GetDateService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ps00008")
@CrossOrigin
public class DataGovController extends CommonController {

    @Autowired
    ApiInterface apiInterface;
    @Autowired
    CombineService commonService;
    @Autowired
    DataGovService dataGovService;
    @Autowired
    FindService findService;
    @Autowired
    GetDateService getDateService;

    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private String portNumber;

    /** 공공데이터포털_건축물연령정보 */
    @GetMapping(value = "tdw_bild_age_info_atrb", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_bild_age_info_atrbs(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String jsonDivide = findService.findJsonDivide(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();


        JsonArray params = findService.findParam(dtst_sn,"params"); // 파라미터 리스트

        for(int j = 0; j < params.size(); j++){
            JsonObject result = dataGovService.getJsonResult(tn_data_bass_info.getData_link_url(), params.get(j).getAsString());
            JsonArray items = dataGovService.getItems(result,jsonDivide,"field");
            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    dataGovService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                    String jsonitem = jsonObj.toString();
                    item = dataGovService.createObject(jsonitem, Tdw_bild_age_info_atrb.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }

    /** 미세먼지 경보 현황 정보 조회 */
    @GetMapping(value = "tdw_minu_dust_alarm_sttus_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_minu_dust_alarm_sttus_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String Year = getDateService.getlastYear();
        String URL = dataGovService.makeYearParameter(tn_data_bass_info.getData_link_url(),Year);
        JsonObject result = dataGovService.getJsonResult(URL);
        JsonArray items = dataGovService.getItems(result);

        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        List<Object> classList = new ArrayList<>();
        Object item;
        if(items.size() > 0){
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj = items.get(i).getAsJsonObject();
                dataGovService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                String jsonitem = jsonObj.toString();
                item = dataGovService.createObject(jsonitem, Tdw_minu_dust_alarm_sttus_info.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }

    /** 미세먼지(중금속) 실시간 정보 */
    @GetMapping(value = "tdw_minu_dust_hml_rltm_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_minu_dust_hml_rltm_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String jsonDivide = findService.findJsonDivide(dtst_sn);
        String Year = getDateService.getYesterday();
        String URL = dataGovService.makeDayParameter(tn_data_bass_info.getData_link_url(),Year);

        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        List<Object> classList = new ArrayList<>();
        Object item;
        JsonObject result = dataGovService.getJsonResult(URL);
        JsonArray items = dataGovService.getItems(result,jsonDivide,"item");
        if(items.size() > 0){
            for (int i = 0; i < items.size(); i++) {
                JsonObject jsonObj = items.get(i).getAsJsonObject();
                dataGovService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                String jsonitem = jsonObj.toString();
                item = dataGovService.createObject(jsonitem, Tdw_minu_dust_hml_rltm_info.class);
                classList.add(item);
                clct_sn++;
            }
        }
        return classList;
    }


    /** 행정동 단위 상가업소 조회 **/
    @GetMapping(value = "tdw_dong_unit_sopsrt_bssh_inq", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object>  tdw_dong_unit_sopsrt_bssh_inq(@RequestParam(value = "dtst_sn") Long dtst_sn)throws IOException , ClassNotFoundException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String jsonDivide = findService.findJsonDivide(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;

        int offset = 1;
        int count = 0;
        String page = "pageNo";
        String perPage = "numOfRows";
        int clct_sn = 1;

        JsonArray key = findService.findParam(dtst_sn, "key");

        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        for (int k = 0; k < key.size(); k++){

            while(true) {
                JsonObject result = dataGovService.getJsonResult(tn_data_bass_info.getData_link_url(), page, perPage, offset, key.get(k).getAsString());
                int totalcount = dataGovService.getTotal(result);
                JsonArray items = dataGovService.getItems(result, jsonDivide, "items");

                if (items.size() > 0) {
                    for (int j = 0; j < items.size(); j++) {
                        JsonObject jsonObj = items.get(j).getAsJsonObject();
                        dataGovService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                        String jsonitem = jsonObj.toString();
                        System.out.println("jsonitem :" + jsonitem);
                        item = dataGovService.createObject(jsonitem, Tdw_dong_unit_sopsrt_bssh_inq.class);
                        classList.add(item);
                        count++;
                        clct_sn++;
                    }
                    if (count == totalcount) {
                        log.info("total : " + totalcount);
                        clct_sn = count + 1;
                        offset = 1;
                        count = 0;
                        break;
                    } else {
                        offset++;
                    }
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
        String PvsnInstNm = tn_data_bass_info.getPvsn_site_cd();
        String packageName = this.getClass().getPackage().getName();
        String className = commonService.makeClassName(packageName,tb_nm);
        Class clazz = Class.forName(className);
        int clct_sn = 1;
        List<Object> classList = new ArrayList<>();

        String multi_paramtr_yn = tn_data_bass_info.getMulti_paramtr_yn();
        String pgng_yn = tn_data_bass_info.getPgng_yn();

        if (multi_paramtr_yn.equals("Y")) {
            String url = commonService.makeUrl(PvsnInstNm,tb_nm,host,portNumber);
            ResponseBody responseBody = apiInterface.getUrl(url,dtst_sn).execute().body();
            classList = commonService.makeLists(responseBody.string());
            return classList;
        }
        else if (pgng_yn.equals("Y")) {
            int offset = 1;
            int count = 0;
            String page = "pageNo";
            String perPage = "numofRows";
            while(true) {
                JsonObject result = dataGovService.getJsonResult(tn_data_bass_info.getData_link_url(),page,perPage,offset);
                int totalcount = dataGovService.getTotal(result);
                JsonArray items = dataGovService.getItems(result);

                if(items.size() > 0){
                    for(int j=0; j < items.size(); j++ ){
                        Object resultObject = dataGovService.createObject(items.get(j).getAsJsonObject().toString(),clazz);
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
            JsonObject result = dataGovService.getJsonResult(tn_data_bass_info.getData_link_url());
            JsonArray items = dataGovService.getItems(result);
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    dataGovService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd());
                    Object item = dataGovService.createObject(jsonObj.toString(), clazz);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }
}
