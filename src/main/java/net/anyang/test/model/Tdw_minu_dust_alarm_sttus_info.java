package net.anyang.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
/*** 에어코리아_미세먼지 경보 발령 현황 정보 ***/
 public class Tdw_minu_dust_alarm_sttus_info {

   @JsonProperty("clct_sn")
    private Integer clct_sn;
   @JsonProperty("sn")
    private String sn;
   @JsonProperty("datadate")
    private String dataDate;
   @JsonProperty("districtname")
    private String districtName;
   @JsonProperty("movename")
    private String moveName;
   @JsonProperty("itemcode")
    private String itemCode;
   @JsonProperty("issuegbn")
    private String issueGbn;
   @JsonProperty("issuedate")
    private String issueDate;
   @JsonProperty("issuetime")
    private String issueTime;
   @JsonProperty("issueval")
    private String issueVal;
   @JsonProperty("cleardate")
    private String clearDate;
   @JsonProperty("cleartime")
    private String clearTime;
   @JsonProperty("clearval")
    private String clearVal;
   @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
   @JsonProperty("clct_dt")
    private String clct_dt;

}
