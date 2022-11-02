package net.anyang.test.controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.ApiInterface;
import net.anyang.test.model.Tn_data_bass_info;
import net.anyang.test.repository.TnDataBassInfoRepository;
import net.anyang.test.service.KosisService;
import net.anyang.test.service.common.CombineService;
import net.anyang.test.service.common.FindService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ps00009")
@CrossOrigin
public class KosisController {

    @Autowired
    TnDataBassInfoRepository tnDataBassInfoRepository;
    @Autowired
    ApiInterface apiInterface;
    @Autowired
    CombineService combineService;
    @Autowired
    FindService findService;
    @Autowired
    KosisService kosisService;

    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private String portNumber;

    @GetMapping(value = "/common", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> common(@RequestParam(value = "dtst_sn") Long dtst_sn) throws ClassNotFoundException,IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String tb_nm = tn_data_bass_info.getInnerClctTblPhysiclNm();
        String packageName = this.getClass().getPackage().getName();
        String className = combineService.makeClassName(packageName,tb_nm);
        Class clazz = Class.forName(className);
        List<Object> classList = new ArrayList<>();
        JsonArray result = kosisService.getJsonResult(tn_data_bass_info.getData_link_url());
        Object item;
        if (result.size() > 0) {
            for (int i = 0; i < result.size(); i++) {
             /*

                Object item = kosisService.createObject(result.get(i).getAsJsonObject().toString(), clazz);
                classList.add(item);
            */
                JsonObject jsonObj = result.get(i).getAsJsonObject();
                kosisService.appendColum(jsonObj);
                String jsonitem = jsonObj.toString();
                item = kosisService.createObject(jsonitem, clazz);
                classList.add(item);
            }

        }
    return classList;
    }

    @SneakyThrows
    @GetMapping(value = "/download", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String download(@RequestParam(value = "dtst_sn") Long dtst_sn) throws ClassNotFoundException,IOException {
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String Url = tn_data_bass_info.getData_link_url();
        String defaultPath = "/home/datanuri/kosiscolTest";
        String file = kosisService.findPath(defaultPath, Url);
        log.info(Url);
        log.info(file);

        try {
            if (kosisService.downLoad(new File(file), Url) == true) {
                log.info("file save ===> " + file);
                return "success";
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }



}
