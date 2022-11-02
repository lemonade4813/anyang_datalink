package net.anyang.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Tdw_arpltn_stats_msrstn_rltm_daly_avrg_info {

    private Integer clct_sn;
    @JsonProperty("msurdt")
    private String msurDt;
    @JsonProperty("msrstnname")
    private String msrstnName;
    @JsonProperty("so2value")
    private String so2Value;
    @JsonProperty("covalue")
    private String coValue;
    @JsonProperty("o3value")
    private String o3Value;
    @JsonProperty("no2value")
    private String no2Value;
    @JsonProperty("pm10value")
    private String pm10Value;
    @JsonProperty("pm25value")
    private String pm25Value;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}
