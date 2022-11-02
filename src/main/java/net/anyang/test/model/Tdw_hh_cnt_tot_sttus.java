package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
/*** 세대원수 별 세대수 집계 현황 ***/
public class Tdw_hh_cnt_tot_sttus {

    private Integer clct_sn;
    @JsonProperty("examin_yy")
    private String EXAMIN_YY;
    @JsonProperty("examin_mt")
    private String EXAMIN_MT;
    @JsonProperty("admzone_div_nm")
    private String ADMZONE_DIV_NM;
    @JsonProperty("admzone_nm")
    private String ADMZONE_NM;
    @JsonProperty("legaldong_cd")
    private String LEGALDONG_CD;
    @JsonProperty("all_hshld_cnt")
    private Integer ALL_HSHLD_CNT;
    @JsonProperty("fammem_1_hshld_cnt")
    private Integer FAMMEM_1_HSHLD_CNT;
    @JsonProperty("fammem_2_hshld_cnt")
    private Integer FAMMEM_2_HSHLD_CNT;
    @JsonProperty("fammem_3_hshld_cnt")
    private Integer FAMMEM_3_HSHLD_CNT;
    @JsonProperty("fammem_4_hshld_cnt")
    private Integer FAMMEM_4_HSHLD_CNT;
    @JsonProperty("fammem_5_hshld_cnt")
    private Integer FAMMEM_5_HSHLD_CNT;
    @JsonProperty("fammem_6_hshld_cnt")
    private Integer FAMMEM_6_HSHLD_CNT;
    @JsonProperty("fammem_7_hshld_cnt")
    private Integer FAMMEM_7_HSHLD_CNT;
    @JsonProperty("fammem_8_hshld_cnt")
    private Integer FAMMEM_8_HSHLD_CNT;
    @JsonProperty("fammem_9_hshld_cnt")
    private Integer FAMMEM_9_HSHLD_CNT;
    @JsonProperty("fammem_10_hshld_cnt")
    private Integer FAMMEM_10_HSHLD_CNT;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;
}
