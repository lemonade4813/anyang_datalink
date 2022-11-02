package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/** 한눈의 보는 민원_최다 민원 키워드 정보_안양시 데이터 **/
public class Tdw_mxm_cvlcpt_kwrd_info {

    private Integer clct_sn;
    private String term;
    private String df;
    private String mainsubcode;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}
