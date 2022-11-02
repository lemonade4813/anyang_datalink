package net.anyang.test.controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.*;
import net.anyang.test.repository.TnDataBassInfoRepository;
import net.anyang.test.service.AnyangService;
import net.anyang.test.service.EpeopleService;
import net.anyang.test.service.common.CombineService;
import net.anyang.test.service.common.FindService;
import net.anyang.test.service.common.GetDateService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/ps10000")
@CrossOrigin
public class AnyangController extends CommonController{
    @Autowired
    TnDataBassInfoRepository tnDataBassInfoRepository;
    @Autowired
    ApiInterface apiInterface;
    @Autowired
    CombineService combineService;
    @Autowired
    AnyangService anyangService;
    @Autowired
    FindService findService;
    @Autowired
    CombineService commonService;

    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private String portNumber;



    /** 장치목록 **/
   /*
    @GetMapping(value = "tdw_device_ll", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_device_ll(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String jsonDivide = findService.findJsonDivide(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();


        JsonArray params = findService.findParam(dtst_sn,"params"); // 파라미터 리스트

        for(int j = 0; j < params.size(); j++){
            JsonObject result = anyangService.getJsonResult(tn_data_bass_info.getData_link_url());
            JsonArray items = anyangService.getItems(result,jsonDivide);
            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    anyangService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                    String jsonitem = jsonObj.toString();
                    item = anyangService.createObject(jsonitem, Tdw_bild_age_info_atrb.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }
    */


    /** 시설목록 **/
    /*
    @GetMapping(value = "tdw_fclty_ll", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_fclty_ll(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String jsonDivide = findService.findJsonDivide(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();


        JsonArray params = findService.findParam(dtst_sn,"params"); // 파라미터 리스트

        for(int j = 0; j < params.size(); j++){
            JsonObject result = anyangService.getJsonResult(tn_data_bass_info.getData_link_url());
            JsonArray items = anyangService.getItems(result,jsonDivide);
            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    anyangService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                    String jsonitem = jsonObj.toString();
                    item = anyangService.createObject(jsonitem, Tdw_bild_age_info_atrb.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }
    */

    /** 데이터목록 **/
    /*
    @GetMapping(value = "tdw_data_ll", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_data_ll(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String jsonDivide = findService.findJsonDivide(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();


        JsonArray params = findService.findParam(dtst_sn,"params"); // 파라미터 리스트

        for(int j = 0; j < params.size(); j++){
            JsonObject result = anyangService.getJsonResult(tn_data_bass_info.getData_link_url(), params.get(j).getAsString());
            JsonArray items = anyangService.getItems(result,jsonDivide);
            if(items.size() > 0){
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    anyangService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                    String jsonitem = jsonObj.toString();
                    item = anyangService.createObject(jsonitem, Tdw_bild_age_info_atrb.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }
    */




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
                JsonObject result = anyangService.getJsonResult(tn_data_bass_info.getData_link_url(),page,perPage,offset);
                int totalcount = anyangService.getTotal(result);
                JsonArray items = anyangService.getItems(result);

                if(items.size() > 0){
                    for(int j=0; j < items.size(); j++ ){
                        Object resultObject = anyangService.createObject(items.get(j).getAsJsonObject().toString(),clazz);
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


    @GetMapping(value ="/waterWay")
    public List<Object> getWaterWayItem(@RequestParam(value = "dtst_sn",defaultValue = "200") Long dtst_sn) throws IOException{

        ResponseEntity<String> result;
        List<Object> classList = new ArrayList<>();

        if (dtst_sn == 200) {
            String query = "코로나";
            ByteBuffer buffer = StandardCharsets.UTF_8.encode(query);
            String encode = StandardCharsets.UTF_8.decode(buffer).toString();

            URI uri = UriComponentsBuilder
                    .fromUriString("https://openapi.naver.com")
                    .path("/v1/search/local.json")
                    .queryParam("query", encode)
                    .queryParam("display", 10)
                    .queryParam("start", 1)
                    .queryParam("sort", "random")
                    .encode()
                    .build()
                    .toUri();

            RestTemplate restTemplate = new RestTemplate();

            // 아래는 헤더를 넣기 위함
            RequestEntity<Void> req = RequestEntity
                    .get(uri)
                    .header("X-Naver-Client-Id", "FiLHgmNbk9_gcTzQJC1H")
                    .header("X-Naver-Client-Secret", "eAHvN9fohO")
                    .build();

            result = restTemplate.exchange(req, String.class);
            Object item;

            int clct_sn = 1;
            String dataUpdtCycle = "day";

            JsonObject jsonObject = new JsonParser().parse(result.getBody()).getAsJsonObject();
            JsonArray items = jsonObject.getAsJsonArray("items");
            if (items.size() > 0) {
                for (int j = 0; j < items.size(); j++) {
                    JsonObject jsonObj = items.get(j).getAsJsonObject();
                    anyangService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                    String jsonitem = jsonObj.toString();
                    System.out.println("jsonitem :" + jsonitem);
                    item = anyangService.createObject(jsonitem, Tdw_wtway_remote_mtinsp_pltfom.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
            return classList;
        } else {
            return null;
        }
    }
}

