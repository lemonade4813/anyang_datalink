package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/** 한눈에 보는 민원_민원발생 기관 순위_지방자치단체 데이터 **/
public class Tdw_cvlcpt_ocrn_inst_rank {

    private Integer clct_sn;
    private Integer hits;
    private String label;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}
