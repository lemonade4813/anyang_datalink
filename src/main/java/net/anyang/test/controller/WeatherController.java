package net.anyang.test.controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.ApiInterface;
import net.anyang.test.model.Tdw_minu_dust_hml_rltm_info;
import net.anyang.test.model.Tdw_srtpd_rl_sttus;
import net.anyang.test.model.Tn_data_bass_info;
import net.anyang.test.service.common.CombineService;
import net.anyang.test.service.common.FindService;
import net.anyang.test.service.WeatherService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ps00011")
@CrossOrigin
public class WeatherController extends CommonController {

    @Autowired
    ApiInterface apiInterface;
    @Autowired
    CombineService combineService;
    @Autowired
    FindService findService;
    @Autowired
    WeatherService weatherService;

    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private String portNumber;


    @GetMapping(value = "/common", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> common(@RequestParam(value = "dtst_sn") Long dtst_sn) throws ClassNotFoundException,IOException {
        //Tn_data_bass_info Table Info
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String multi_paramtr_yn = tn_data_bass_info.getMulti_paramtr_yn();  // 다중 파라미터 여부
        String pgng_yn = tn_data_bass_info.getPgng_yn();                    // Paging 처리 여부
        String tb_nm = tn_data_bass_info.getInnerClctTblPhysiclNm();        // 내부수집테이블물리명
        String pvsnInstNm = tn_data_bass_info.getPvsn_inst_nm();            // 제공기관명
        log.info("DW 적재 여부 : " + tn_data_bass_info.getDw_ldadng_yn());


        //Instance Create
        String packageName = this.getClass().getPackage().getName();
        String className = combineService.makeClassName(packageName,tb_nm);
        Class clazz = Class.forName(className);
        List<Object> classList = new ArrayList<>();

        if (multi_paramtr_yn.equals("Y")) {
            String url = combineService.makeUrl(pvsnInstNm,tb_nm,host,portNumber);
            ResponseBody responseBody = apiInterface.getUrl(url).execute().body();
            classList = combineService.makeLists(responseBody.string());
            return classList;
        }
        else if (pgng_yn.equals("Y")) {
            int offset = 1;
            int count = 0;
            String page = "pindex";
            String perPage = "psize";
            while(true) {
                JsonObject result = weatherService.getJsonResult(tn_data_bass_info.getData_link_url(),page,perPage,offset);
                int totalcount = weatherService.getTotal(result);
                JsonArray items = weatherService.getItems(result);
                if(items.size() > 0){
                    for(int j=0; j < items.size(); j++ ){
                        Object resultObject = weatherService.createObject(items.get(j).getAsJsonObject().toString(),clazz);
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
        else if(tn_data_bass_info.getDw_ldadng_yn().equals("N")){

            JsonObject result = weatherService.getJsonResult(tn_data_bass_info.getData_link_url());
            JsonArray items = weatherService.getItems(result);
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    Object item = weatherService.createObject(jsonObj.toString(), clazz);
                    classList.add(item);
                }
            }
        }
        else {
            String yesterday = weatherService.getYesterday();
            JsonObject result = weatherService.getJsonResult(tn_data_bass_info.getData_link_url(),yesterday);
            JsonArray items = weatherService.getItems(result);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    weatherService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd());
                    Object item = weatherService.createObject(jsonObj.toString(), clazz);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }
}
