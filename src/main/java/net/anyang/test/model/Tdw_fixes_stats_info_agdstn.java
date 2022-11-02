package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/** 한눈애 보는 민원_맞춤형통계 정보_연령별_안양시 데이터 **/

public class Tdw_fixes_stats_info_agdstn {

    private Integer clct_sn;
    private Integer hits;
    private String label;
    private String age;
    private String mainsubcode;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}



