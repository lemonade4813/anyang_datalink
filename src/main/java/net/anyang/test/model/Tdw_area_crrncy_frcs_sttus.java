package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;
import java.util.Date;

@Getter
@Setter
/*** 지역화폐 가맹점 현황 ***/
public class Tdw_area_crrncy_frcs_sttus {

    private Integer clct_sn;
    @JsonProperty("sigun_nm")
    private String SIGUN_NM;
    @JsonProperty("cmpnm_nm")
    private String CMPNM_NM;
    @JsonProperty("indutype_nm")
    private String INDUTYPE_NM;
    @JsonProperty("refine_roadnm_addr")
    private String REFINE_ROADNM_ADDR;
    @JsonProperty("refine_lotno_addr")
    private String REFINE_LOTNO_ADDR;
    @JsonProperty("live_yn")
    private String LIVE_YN;
    @JsonProperty("data_std_de")
    private String DATA_STD_DE;
    @Nullable
    @JsonProperty("zip_cd")
    private String ZIP_CD;
    @Nullable
    @JsonProperty("lat")
    private Float  LAT;
    @Nullable
    @JsonProperty("logt")
    private Float  LOGT;
    @JsonProperty("bizregno")
    private String BIZREGNO;
    @JsonProperty("indutype_cd")
    private String INDUTYPE_CD;
    @Nullable
    @JsonProperty("frcs_no")
    private Integer FRCS_NO;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}
