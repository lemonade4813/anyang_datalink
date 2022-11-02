package net.anyang.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
/**** 경기도_실내공기질 관리법 적용대상 다중이용시설 현황 ****/
public class Tdw_gg_indoor_air_mng_trgt_ftbnpl_sttus {
    private Integer clct_sn;
    @JsonProperty("sigun_cd")
    private String SIGUN_CD;
    @JsonProperty("sigun_nm")
    private String SIGUN_NM;
    @JsonProperty("faclt_div_nm")
    private String FACLT_DIV_NM;
    @JsonProperty("faclt_nm")
    private String FACLT_NM;
    @JsonProperty("telno")
    private String TELNO;
    @JsonProperty("yy_ar")
    private String YY_AR;
    @JsonProperty("seat_cnt")
    private String SEAT_CNT;
    @JsonProperty("data_std_de")
    private String DATA_STD_DE;
    @JsonProperty("refine_lotno_addr")
    private String REFINE_LOTNO_ADDR;
    @JsonProperty("refine_roadnm_addr")
    private String REFINE_ROADNM_ADDR;
    @JsonProperty("refine_wgs84_lat")
    private String REFINE_WGS84_LAT;
    @JsonProperty("refine_wgs84_logt")
    private String REFINE_WGS84_LOGT;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}
