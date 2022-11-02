package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/** 한눈에 보는 민원_키워드 기반 민원 건수 정보_안양시 데이터 **/
public class
Tdw_kwrd_fnd_cvlcpt_nocs_info {

    private Integer clct_sn;
    private String pttn;
    private String dfpt;
    private String saeol;
    private String prpl;
    private String mainsubcode;
    private String searchword;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}
