package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*** 행정동 단위 상가업소 조회 ***/
 public class Tdw_dong_unit_sopsrt_bssh_inq {

   @JsonProperty("clct_sn")
    private Integer clct_sn;
   @JsonProperty("bizesid")
    private String bizesId;
   @JsonProperty("bizesnm")
    private String bizesNm;
   @JsonProperty("brchnm")
    private String brchNm;
   @JsonProperty("indslclscd")
    private String indsLclsCd;
   @JsonProperty("indslclsnm")
    private String indsLclsNm;
   @JsonProperty("indsmclscd")
    private String indsMclsCd;
   @JsonProperty("indsmclsnm")
    private String indsMclsNm;
   @JsonProperty("indssclscd")
    private String indsSclsCd;
   @JsonProperty("indssclsnm")
    private String indsSclsNm;
   @JsonProperty("ksiccd")
    private String ksicCd;
   @JsonProperty("ksicnm")
    private String ksicNm;
   @JsonProperty("ctprvncd")
   private String ctprvnCd;
   @JsonProperty("ctprvnnm")
   private String ctprvnNm;
   @JsonProperty("signgucd")
   private String signguCd;
   @JsonProperty("signgunm")
   private String signguNm;
   @JsonProperty("adongcd")
   private String adongCd;
   @JsonProperty("adongnm")
   private String adongNm;
   @JsonProperty("ldongcd")
   private String ldongCd;
   @JsonProperty("ldongnm")
   private String ldongNm;
   @JsonProperty("lnocd")
   private String lnoCd;
   @JsonProperty("plotsctcd")
   private String plotSctCd;
   @JsonProperty("plotsctnm")
   private String plotSctNm;
   @JsonProperty("lnomnno")
   private Long lnoMnno;
   @JsonProperty("lnoslno")
   private String lnoSlno;
   @JsonProperty("lnoadr")
   private String lnoAdr;
   @JsonProperty("rdnmcd")
   private String rdnmCd;
   @JsonProperty("rdnm")
   private String rdnm;
   @JsonProperty("bldmnno")
   private Long bldMnno;
   @JsonProperty("bldslno")
   private String bldSlno;
   @JsonProperty("bldmngno")
   private String bldMngNo;
   @JsonProperty("bldnm")
   private String bldNm;
   @JsonProperty("rdnmadr")
   private String rdnmAdr;
   @JsonProperty("oldzipcd")
   private String oldZipcd;
   @JsonProperty("newzipcd")
   private String newZipcd;
   @JsonProperty("dongno")
   private String dongNo;
   @JsonProperty("flrno")
   private String flrNo;
   @JsonProperty("hono")
   private String hoNo;
   @JsonProperty("lon")
   private Double lon;
   @JsonProperty("lat")
   private Double lat;
   @JsonProperty("data_crtr_pnttm")
   private String data_crtr_pnttm;
   @JsonProperty("clct_dt")
   private String clct_dt;
}
