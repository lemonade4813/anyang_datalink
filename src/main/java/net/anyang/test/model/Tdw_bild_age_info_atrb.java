package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
/*** 건축물 연령정보 속성  ***/
public class Tdw_bild_age_info_atrb {

    @JsonProperty("clct_sn")
    private Integer clct_sn;
    @JsonProperty("gisidntfcno")
    private String gisIdntfCno;
    @JsonProperty("pnu")
    private String pnu;
    @JsonProperty("ldcode")
    private String ldCode;
    @JsonProperty("ldcodenm")
    private String ldCodeNm;
    @JsonProperty("regstrsecode")
    private String regstrSeCode;
    @JsonProperty("regstrsecodenm")
    private String regstrSeCodeNm;
    @JsonProperty("mnnmslno")
    private String mnnmSlno;
    @JsonProperty("buldidntfcno")
    private String buldIdntfcNo;
    @JsonProperty("agbldgsecode")
    private String agbldgSeCode;
    @JsonProperty("agbldgsecodenm")
    private String agbldgSeCodeNm;
    @JsonProperty("buldkndcode")
    private String buldKndCode;
    @JsonProperty("buldkndcodenm")
    private String buldKndCodeNm;
    @JsonProperty("buldnm")
    private String buldNm;
    @JsonProperty("bulddongnm")
    private String buldDongNm;
    @JsonProperty("buldtotar")
    private String buldTotar;
    @JsonProperty("strctcode")
    private String strctCode;
    @JsonProperty("strctcodenm")
    private String strctCodeNm;
    @JsonProperty("mainprposcode")
    private String mainPrposCode;
    @JsonProperty("mainprposcodenm")
    private String mainPrposCodeNm;
    @JsonProperty("buldhg")
    private String buldHg;
    @JsonProperty("groundfloorco")
    private String groundFloorCo;
    @JsonProperty("undgrndfloorco")
    private String undgrndFloorCo;
    @JsonProperty("prmisnde")
    private String prmisnDe;
    @JsonProperty("useconfmde")
    private String useConfmDe;
    @JsonProperty("buldage")
    private String buldAge;
    @JsonProperty("agrdesecode")
    private String agrdeSeCode;
    @JsonProperty("agrdesecodenm")
    private String agrdeSeCodeNm;
    @JsonProperty("agrde5classsecode")
    private String agrde5ClassSeCode;
    @JsonProperty("agrde5classsecodenm")
    private String agrde5ClassSeCodeNm;
    @JsonProperty("lastupdtdt")
    private String lastUpdtDt;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;
}
