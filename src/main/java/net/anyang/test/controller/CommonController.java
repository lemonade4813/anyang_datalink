package net.anyang.test.controller;

import net.anyang.test.repository.TnDataBassInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public abstract class CommonController {
    @Autowired
    TnDataBassInfoRepository tnDataBassInfoRepository;

    @RequestMapping(value = "/common", consumes = MediaType.APPLICATION_JSON_VALUE)
    public abstract List<Object> common(@RequestParam(value = "dtst_sn") Long dtst_sn) throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;


//    Class clazz = Class.forName("net.hwj.practice.model." + tb_nm.substring(0, 1).toUpperCase()+tb_nm.substring(1).toLowerCase());
//
//    List<Object> classList = new ArrayList<>();
//    Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneByInnerClctTblPhysiclNm(tb_nm);
//
//    /**** json 받아와서 list로 변환하는 부분 ****/
//    JsonObject result = new JsonObject();
//    int totalcount;
//    JsonArray items = null;
//        if (items.size() > 0) {
//        for (int i = 0; i < items.size(); i++) {
//            Object item = null;
//            classList.add(item);
//        }
//    }
//
//        return classList;
}
