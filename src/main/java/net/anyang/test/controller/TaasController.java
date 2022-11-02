package net.anyang.test.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.*;
import net.anyang.test.repository.TnDataBassInfoRepository;
import net.anyang.test.service.TaasService;
import net.anyang.test.service.common.CombineService;
import net.anyang.test.service.common.FindService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;



@Slf4j
@RestController
@RequestMapping("/ps00003")
@CrossOrigin
@Configuration
public class TaasController extends CommonController{
    @Autowired
    TnDataBassInfoRepository tnDataBassInfoRepository;
    @Autowired
    ApiInterface apiInterface;
    @Autowired
    TaasService taasService;
    @Autowired
    FindService findService;
    @Autowired
    CombineService combineService;

    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private String portNumber;

    /** 자건거 사고다발지역 정보 **/
    @GetMapping(value = "tdw_bcycl_acdnt_mlttd_area_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_bcycl_acdnt_mlttd_area_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        JsonArray searchYearCd = findService.findParam(dtst_sn, "searchYearCd"); // tb_nm 다중 파라미터 리스트
        JsonArray guGun = findService.findParam(dtst_sn, "guGun"); // tb_nm 다중 파라미터 리스트

        for(int k = 0; k<searchYearCd.size(); k++) {
            for (int j = 0; j < guGun.size(); j++)   {
                JsonObject result = taasService.getJsonResult(tn_data_bass_info.getData_link_url(), searchYearCd.get(k).getAsString(), guGun.get(j).getAsString());
                JsonArray items = taasService.getItems(result);

                if (items.size() > 0) {
                    for (int i = 0; i < items.size(); i++) {
                        JsonObject jsonObj = items.get(i).getAsJsonObject();
                        taasService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                        String jsonitem = jsonObj.toString();
                        item = taasService.createObject(jsonitem, Tdw_bcycl_acdnt_mlttd_area_info.class);
                        classList.add(item);
                        clct_sn++;
                    }
                }
            }
        }

        return classList;

    }


    /** 보행고령자 사고다발지역정보 **/
    @GetMapping(value = "tdw_pdstrn_adnge_man_acdnt_mlttd_area_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_pdstrn_adnge_man_acdnt_mlttd_area_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        JsonArray searchYearCd = findService.findParam(dtst_sn, "searchYearCd"); // tb_nm 다중 파라미터 리스트
        JsonArray guGun = findService.findParam(dtst_sn, "guGun"); // tb_nm 다중 파라미터 리스트

        for(int k = 0; k<searchYearCd.size(); k++) {
            for (int j = 0; j < guGun.size(); j++)   {
                JsonObject result = taasService.getJsonResult(tn_data_bass_info.getData_link_url(), searchYearCd.get(k).getAsString(), guGun.get(j).getAsString());
                JsonArray items = taasService.getItems(result);
                if (items.size() > 0) {
                    for (int i = 0; i < items.size(); i++) {
                        JsonObject jsonObj = items.get(i).getAsJsonObject();
                        taasService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                        String jsonitem = jsonObj.toString();
                        item = taasService.createObject(jsonitem, Tdw_bcycl_acdnt_mlttd_area_info.class);
                        classList.add(item);
                        clct_sn++;
                    }
                }
            }
        }

        return classList;

    }

    /** 보행어린이 사고다발 지역정보 **/
    @GetMapping(value = "tdw_pdstrn_child_acdnt_mlttd_area_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_pdstrn_child_acdnt_mlttd_area_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        JsonArray searchYearCd = findService.findParam(dtst_sn, "searchYearCd"); // tb_nm 다중 파라미터 리스트
        JsonArray guGun = findService.findParam(dtst_sn, "guGun"); // tb_nm 다중 파라미터 리스트

        for(int k = 0; k<searchYearCd.size(); k++) {
            for (int j = 0; j < guGun.size(); j++)   {
                JsonObject result = taasService.getJsonResult(tn_data_bass_info.getData_link_url(), searchYearCd.get(k).getAsString(), guGun.get(j).getAsString());
                JsonArray items = taasService.getItems(result);
                if (items.size() > 0) {
                    for (int i = 0; i < items.size(); i++) {
                        JsonObject jsonObj = items.get(i).getAsJsonObject();
                        taasService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                        String jsonitem = jsonObj.toString();
                        item = taasService.createObject(jsonitem, Tdw_bcycl_acdnt_mlttd_area_info.class);
                        classList.add(item);
                        clct_sn++;;
                    }
                }
            }
        }

        return classList;

    }

    /** 스쿨존내 어린이 사고다발 지역정보 **/
    @GetMapping(value = "tdw_schul_zone_ise_child_acdnt_mlttd_area_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_schul_zone_ise_child_acdnt_mlttd_area_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();


        JsonArray searchYearCd = findService.findParam(dtst_sn, "searchYearCd"); // tb_nm 다중 파라미터 리스트
        JsonArray guGun = findService.findParam(dtst_sn, "guGun"); // tb_nm 다중 파라미터 리스트

        for(int k = 0; k<searchYearCd.size(); k++) {
            for (int j = 0; j < guGun.size(); j++)   {
                JsonObject result = taasService.getJsonResult(tn_data_bass_info.getData_link_url(), searchYearCd.get(k).getAsString(), guGun.get(j).getAsString());
                JsonArray items = taasService.getItems(result);

                if (items.size() > 0) {
                    for (int i = 0; i < items.size(); i++) {
                        JsonObject jsonObj = items.get(i).getAsJsonObject();
                        taasService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                        String jsonitem = jsonObj.toString();
                        item = taasService.createObject(jsonitem, Tdw_bcycl_acdnt_mlttd_area_info.class);
                        classList.add(item);
                        clct_sn++;
                    }
                }
            }
        }

        return classList;

    }


    /** 법규 위반별 사고다발지역 정보 **/
    @GetMapping(value = "tdw_lrg_violt_accto_acdnt_mlttd_area_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_lrg_violt_accto_acdnt_mlttd_area_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        JsonArray searchYearCd = findService.findParam(dtst_sn, "searchYearCd"); // tb_nm 다중 파라미터 리스트
        JsonArray guGun = findService.findParam(dtst_sn, "guGun"); // tb_nm 다중 파라미터 리스트

        for(int k = 0; k<searchYearCd.size(); k++) {
            for (int j = 0; j < guGun.size(); j++)   {
                JsonObject result = taasService.getJsonResult(tn_data_bass_info.getData_link_url(), searchYearCd.get(k).getAsString(), guGun.get(j).getAsString());
                JsonArray items = taasService.getItems(result);
                if (items.size() > 0) {
                    for (int i = 0; i < items.size(); i++) {
                        JsonObject jsonObj = items.get(i).getAsJsonObject();
                        taasService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                        String jsonitem = jsonObj.toString();
                        item = taasService.createObject(jsonitem, Tdw_bcycl_acdnt_mlttd_area_info.class);
                        classList.add(item);
                        clct_sn++;
                    }
                }
            }
        }

        return classList;

    }

    /** 지자체별 사고다발지역 정보 **/
    @GetMapping(value = "tdw_locgov_accto_acdnt_mlttd_area_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_locgov_accto_acdnt_mlttd_area_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        JsonArray searchYearCd = findService.findParam(dtst_sn, "searchYearCd"); // tb_nm 다중 파라미터 리스트

        for (int j = 0; j <searchYearCd.size(); j++)   {
            JsonObject result = taasService.getJsonResult(tn_data_bass_info.getData_link_url(), searchYearCd.get(j).getAsString());
            JsonArray items = taasService.getItems(result);
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    taasService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                    String jsonitem = jsonObj.toString();
                    item = taasService.createObject(jsonitem, Tdw_bcycl_acdnt_mlttd_area_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }

        return classList;

    }


    /** 결빙 사고다발지역 정보 **/
    @GetMapping(value = "tdw_frez_acdnt_mlttd_area_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_frez_acdnt_mlttd_area_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        JsonArray searchYearCd = findService.findParam(dtst_sn, "searchYearCd"); // tb_nm 다중 파라미터 리스트

        for (int j = 0; j <searchYearCd.size(); j++)   {
            JsonObject result = taasService.getJsonResult(tn_data_bass_info.getData_link_url(), searchYearCd.get(j).getAsString());
            JsonArray items = taasService.getItems(result);
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    taasService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                    String jsonitem = jsonObj.toString();
                    item = taasService.createObject(jsonitem, Tdw_bcycl_acdnt_mlttd_area_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }

        return classList;

    }

    /** 이륜차 사고다발지역 정보 **/
    @GetMapping(value = "tdw_twhlvhcl_acdnt_mlttd_area_info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> tdw_twhlvhcl_acdnt_mlttd_area_info(@RequestParam(value = "dtst_sn") Long dtst_sn) throws IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        List<Object> classList = new ArrayList<>();
        Object item;
        int clct_sn = 1;
        String dataUpdtCycle = tn_data_bass_info.getData_updt_cycle_cd();

        JsonArray guGun = findService.findParam(dtst_sn, "guGun"); // tb_nm 다중 파라미터 리스트

        for (int j = 0; j <guGun.size(); j++)   {
            JsonObject result = taasService.getJsonResult(tn_data_bass_info.getData_link_url(), guGun.get(j).getAsString());
            JsonArray items = taasService.getItems(result);

            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj = items.get(i).getAsJsonObject();
                    taasService.appendColum(jsonObj, clct_sn, dataUpdtCycle);
                    String jsonitem = jsonObj.toString();
                    item = taasService.createObject(jsonitem, Tdw_bcycl_acdnt_mlttd_area_info.class);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }



    @GetMapping(value = "/common",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> common(@RequestParam(value="dtst_sn") Long dtst_sn) throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String tb_nm = tn_data_bass_info.getInnerClctTblPhysiclNm();
        String pvsnInstNm = tn_data_bass_info.getPvsn_site_cd();



        List<Object> classList = new ArrayList<>();
        String multi_paramtr_yn = tn_data_bass_info.getMulti_paramtr_yn();

        if (multi_paramtr_yn.equals("Y")) {
            String url = combineService.makeUrl(pvsnInstNm,tb_nm,host,portNumber);
            ResponseBody responseBody = apiInterface.getUrl(url,dtst_sn).execute().body();
            classList = combineService.makeLists(responseBody.string());
            return classList;
        }
        return classList;
    }

}
