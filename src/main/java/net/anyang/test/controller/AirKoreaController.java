package net.anyang.test.controller;


import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.*;
import net.anyang.test.repository.TnDataBassInfoRepository;
import net.anyang.test.service.AirKoreaService;
import net.anyang.test.service.common.CombineService;
import net.anyang.test.service.common.FindService;
import okhttp3.ResponseBody;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ps00002")
@CrossOrigin
public class AirKoreaController extends CommonController{
    @Autowired
    TnDataBassInfoRepository tnDataBassInfoRepository;
    @Autowired
    ApiInterface apiInterface;
    @Autowired
    CombineService combineService;
    @Autowired
    AirKoreaService airKoreaService;
    @Autowired
    FindService findService;

    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private String portNumber;

    /** 에어코리아_측정소별 실시간 측정정보 조회 */
    @GetMapping(value = "tdw_arpltn_msrstn_rltm_mesure_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_arpltn_msrstn_rltm_mesure_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        JsonArray params = findService.findParam(dtst_sn,"params"); // tb_nm 다중 파라미터 리스트
        int clct_sn = 1;
        List<Object> classList = new ArrayList<>();
        Object item;
        for(int j = 0; j < params.size(); j++){
            String stationName = params.get(j).toString();
            stationName = stationName.substring(0, stationName.length() - 1);
            stationName = stationName.substring(1);
            JsonObject result = airKoreaService.getJsonResult(tn_data_bass_info.getData_link_url(),params.get(j).getAsString());
            JsonArray items = airKoreaService.getItems(result);

            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    airKoreaService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(),stationName);
                    String jsonitem = jsonObj.toString();
                    item = airKoreaService.createObject(jsonitem, Tdw_arpltn_msrstn_rltm_mesure_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }
    /** 에어코리아_측정소별 실시간 측정정보 조회 시간별*/
    @GetMapping(value = "tdw_arpltn_msrstn_rltm_mesure_info_hour", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_arpltn_msrstn_rltm_mesure_info_hour(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        JsonArray params = findService.findParam(dtst_sn,"params"); // tb_nm 다중 파라미터 리스트
        int clct_sn = 1;
        List<Object> classList = new ArrayList<>();
        Object item;
        for(int j = 0; j < params.size(); j++){
            String stationName = params.get(j).toString();
            stationName = stationName.substring(0, stationName.length() - 1);
            stationName = stationName.substring(1);
            JsonObject result = airKoreaService.getJsonResult(tn_data_bass_info.getData_link_url(),params.get(j).getAsString());
            JsonArray items = airKoreaService.getItems(result);

            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    airKoreaService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(),stationName);
                    String jsonitem = jsonObj.toString();
                    item = airKoreaService.createObject(jsonitem, Tdw_arpltn_msrstn_rltm_mesure_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }

    /** 에어코리아 대기오염통계현황 측정소별 실시간 일평균 정보 조회 */
    @GetMapping(value = "tdw_arpltn_stats_msrstn_rltm_daly_avrg_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_arpltn_stats_msrstn_rltm_daly_avrg_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String inqBginMm = airKoreaService.getYesterday();
        String inqEndMm = airKoreaService.getNowDay();
        String URL = airKoreaService.makeDayParameter(tn_data_bass_info.getData_link_url(),inqBginMm,inqEndMm);
        List<Object> classList = new ArrayList<>();
        Object item;
        String paramNm = findService.findParamNm(dtst_sn);
        JsonArray params = findService.findParam(dtst_sn,"params"); // tb_nm 다중 파라미터 리스트
        int clct_sn = 1;
        for(int j = 0; j < params.size(); j++){
            JsonObject result = airKoreaService.getJsonResult(URL,paramNm,params.get(j).getAsString());
            JsonArray items = airKoreaService.getItems(result);
            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    airKoreaService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(),null);
                    String jsonitem = jsonObj.toString();
                    item = airKoreaService.createObject(jsonitem, Tdw_arpltn_stats_msrstn_rltm_daly_avrg_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }

    /** 에어코리아 대기오염통계현황 측정소별 실시간 월평균 정보 조회 */
    @GetMapping(value = "tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        String inqBginMm = airKoreaService.getBeforeMonth();
        String inqEndMm = airKoreaService.getNowMonth();
        String URL = airKoreaService.makeMonthParameter(tn_data_bass_info.getData_link_url(),inqBginMm,inqEndMm);
        String paramNm = findService.findParamNm(dtst_sn);
        JsonArray params = findService.findParam(dtst_sn,"params"); // tb_nm 다중 파라미터 리스트
        int clct_sn = 1;
        for(int j = 0; j < params.size(); j++){
            JsonObject result = airKoreaService.getJsonResult(URL,paramNm,params.get(j).getAsString());
            JsonArray items = airKoreaService.getItems(result);
            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    airKoreaService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd(),null);
                    String jsonitem = jsonObj.toString();
                    item = airKoreaService.createObject(jsonitem, Tdw_arpltn_stats_msrstn_rltm_mnby_avrg_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }


    @Override
    @GetMapping(value = "/common", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> common(@RequestParam(value = "dtst_sn") Long dtst_sn) throws ClassNotFoundException,IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String tb_nm = tn_data_bass_info.getInnerClctTblPhysiclNm();
        String pvsnInstNm = tn_data_bass_info.getPvsn_site_cd();
        String packageName = this.getClass().getPackage().getName();
        String className = combineService.makeClassName(packageName,tb_nm);
        Class clazz = Class.forName(className);
        log.info(clazz.getName());
        List<Object> classList = new ArrayList<>();
        String multi_paramtr_yn = tn_data_bass_info.getMulti_paramtr_yn();
        String pgng_yn = tn_data_bass_info.getPgng_yn();

        if (multi_paramtr_yn.equals("Y")) {
            String url = combineService.makeUrl(pvsnInstNm,tb_nm,host,portNumber);
            log.info("URL : " + url);
            ResponseBody responseBody = apiInterface.getUrl(url,dtst_sn).execute().body();
            classList = combineService.makeLists(responseBody.string());
            return classList;
        }
        else if (pgng_yn.equals("Y")) {
            int offset = 1;
            int count = 0;

            String page = "pageNo";
            String perPage = "numofRows";
            while(true) {
                JsonObject result = airKoreaService.getJsonResult(tn_data_bass_info.getData_link_url(),page,perPage,offset);
                int totalcount = airKoreaService.getTotal(result);
                JsonArray items = airKoreaService.getItems(result);

                if(items.size() > 0){
                    for(int j=0; j < items.size(); j++ ){
                        JsonObject jsonObj = items.get(j).getAsJsonObject();
                        airKoreaService.appendColum(jsonObj, j, tn_data_bass_info.getData_updt_cycle_cd(),null);
                        String jsonitem = jsonObj.toString();
                        Object resultObject = airKoreaService.createObject(jsonitem,clazz);
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
            JsonObject result = airKoreaService.getJsonResult(tn_data_bass_info.getData_link_url());
            JsonArray items = airKoreaService.getItems(result);

            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    airKoreaService.appendColum(jsonObj, i+1, tn_data_bass_info.getData_updt_cycle_cd(),null);
                    String jsonitem = jsonObj.toString();
                    Object item = airKoreaService.createObject(jsonitem, clazz);
                    classList.add(item);
                }
            }
        }
        return classList;
    }

}


