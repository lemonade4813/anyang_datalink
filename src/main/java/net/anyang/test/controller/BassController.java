package net.anyang.test.controller;//package net.hwj.practice.controller;


import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.Tn_data_bass_info;
import net.anyang.test.repository.TnDataBassInfoRepository;
import net.anyang.test.service.TnDataBassInfoService;
import net.anyang.test.VO.TnDataBassInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/bass")
@CrossOrigin
public class BassController {
    @Autowired
    TnDataBassInfoRepository tnDataBassInfoRepository;
    @Autowired
    TnDataBassInfoService tnDataBassInfoService;


//    @CrossOrigin
//    @GetMapping(value = "/list")
//    public Map<String, Object> list(@RequestParam(value = "perPage", defaultValue = "5") Integer perPage,
//                                    @RequestParam(value = "page", defaultValue = "1") Integer currentPage){
//        Map<String,Object> result = new HashMap<>();
//
//        return result;
//    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody TnDataBassInfoVo bassInfoVo){

        System.out.println(bassInfoVo);
        Tn_data_bass_info tn_data_bass_info = tnDataBassInfoService.save(bassInfoVo);
        return new ResponseEntity<>(tn_data_bass_info,HttpStatus.OK);
    }



}
