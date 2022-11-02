package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*** 국립환경과학원_미세먼지(중금속) 실시간 정보 ***/
 public class Tdw_minu_dust_hml_rltm_info {

   @JsonProperty("clct_sn")
    private Integer clct_sn;
   @JsonProperty("sdate")
    private String   SDATE;
   @JsonProperty("stationcode")
    private Integer  STATIONCODE;
   @JsonProperty("itemcode")
    private String   ITEMCODE;
   @JsonProperty("timecode")
    private String   TIMECODE;
   @JsonProperty("value")
    private Float    VALUE;
   @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
   @JsonProperty("clct_dt")
    private String clct_dt;

}
