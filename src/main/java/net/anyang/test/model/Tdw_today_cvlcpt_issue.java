package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
/** 한눈에 보는 민원 - 오늘의 민원이슈 정보_안양시/경기도 데이터 **/
public class Tdw_today_cvlcpt_issue{

    private Integer clct_sn;
    private String topic;
    private Integer rank;
    private Integer count;
    private String mainsubcode;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;
}
