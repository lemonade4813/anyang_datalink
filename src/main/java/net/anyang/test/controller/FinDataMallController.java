package net.anyang.test.controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.ApiInterface;
import net.anyang.test.model.Tn_data_bass_info;
import net.anyang.test.service.FinDataMallService;
import net.anyang.test.service.common.CombineService;
import net.anyang.test.service.common.FindService;
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
@RequestMapping("/ps00010")
@CrossOrigin
public class FinDataMallController extends CommonController {

    @Autowired
    ApiInterface apiInterface;
    @Autowired
    CombineService combineService;
    @Autowired
    FindService findService;
    @Autowired
    FinDataMallService findatamallService;

    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private String portNumber;

    @GetMapping(value = "/common", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> common(@RequestParam(value = "dtst_sn") Long dtst_sn) throws ClassNotFoundException,IOException {
        //Tn_data_bass_info Table Info
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String multi_paramtr_yn = tn_data_bass_info.getMulti_paramtr_yn();
        String pgng_yn = tn_data_bass_info.getPgng_yn();
        String tb_nm = tn_data_bass_info.getInnerClctTblPhysiclNm();
        String jsonDvide = findService.findJsonDivide(dtst_sn);
        String pvsnInstNm = tn_data_bass_info.getPvsn_inst_nm();
        String packageName = this.getClass().getPackage().getName();
        String className = combineService.makeClassName(packageName,tb_nm);
        Class clazz = Class.forName(className);
        List<Object> classList = new ArrayList<>();
        log.info(clazz.getName());

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
            int clct_sn = 1;
            while(true) {
                JsonObject result = findatamallService.getJsonResult(tn_data_bass_info.getData_link_url(),page,perPage,offset);
                int totalcount = findatamallService.getTotal(result,jsonDvide);
                JsonArray items = findatamallService.getItems(result,jsonDvide);
                if(items.size() > 0){
                    for(int j=0; j < items.size(); j++ ){
                        JsonObject jsonObj =items.get(j).getAsJsonObject();
                        findatamallService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd());
                        Object resultObject = findatamallService.createObject(items.get(j).getAsJsonObject().toString(),clazz);
                        classList.add(resultObject);
                        count ++;
                        clct_sn++;
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
            JsonObject result = findatamallService.getJsonResult(tn_data_bass_info.getData_link_url());
            JsonArray items = findatamallService.getItems(result,jsonDvide);
            int clct_sn = 1;
            if (items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject jsonObj =items.get(i).getAsJsonObject();
                    findatamallService.appendColum(jsonObj, clct_sn, tn_data_bass_info.getData_updt_cycle_cd());
                    Object item = findatamallService.createObject(jsonObj.toString(), clazz);
                    classList.add(item);
                    clct_sn++;
                }
            }
        }
        return classList;
    }
}
