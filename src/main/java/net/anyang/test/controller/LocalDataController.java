package net.anyang.test.controller;


import com.google.gson.JsonArray;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.ApiInterface;
import net.anyang.test.model.Tn_data_bass_info;
import net.anyang.test.repository.TnDataBassInfoRepository;
import net.anyang.test.service.KosisService;
import net.anyang.test.service.LocalDataService;
import net.anyang.test.service.common.CombineService;
import net.anyang.test.service.common.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Slf4j
@RestController
@RequestMapping("/ps00015")
@CrossOrigin
public class LocalDataController {

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
    @Autowired
    LocalDataService localDataService;

    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private String portNumber;


    @SneakyThrows
    @GetMapping(value = "/download", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> download(@RequestParam(value = "dtst_sn") Long dtst_sn,
                                   @RequestParam(value = "flpth") String flpth
                                   ) throws ClassNotFoundException, IOException {

        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoRepository.findOneBydtstSn(dtst_sn);
        String address = tn_data_bass_info.getData_link_url();

        String folderPath = localDataService.findFolderPath(flpth);
        log.info("filePath : " + folderPath);
        String filePath = localDataService.findFilePath(folderPath);
        log.info("folderPath : " + filePath);

        ResponseEntity response;

        if(localDataService.downLoad(address, filePath, folderPath) == true){
            response = new ResponseEntity("success",HttpStatus.OK);
        } else{
            response = new ResponseEntity("failed",HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}

