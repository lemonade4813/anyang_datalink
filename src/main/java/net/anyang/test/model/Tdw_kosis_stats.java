package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/** 통계청 제공 다수 원천데이터 통합저장 **/
public class Tdw_kosis_stats {

    @JsonProperty("org_id")
    private String ORG_ID;

    @JsonProperty("tbl_id")
    private String TBL_ID;

    @JsonProperty("tbl_nm")
    private String TBL_NM;

    @JsonProperty("c1_obj_nm")
    private String C1_OBJ_NM;

    @JsonProperty("c1_obj_nm_eng")
    private String C1_OBJ_NM_ENG;

    @JsonProperty("c1")
    private String C1;

    @JsonProperty("c1_nm")
    private String C1_NM;

    @JsonProperty("c1_nm_eng")
    private String C1_NM_ENG;

    @JsonProperty("c2_obj_nm")
    private String C2_OBJ_NM;

    @JsonProperty("c2_obj_nm_eng")
    private String C2_OBJ_NM_ENG;

    @JsonProperty("c2")
    private String C2;

    @JsonProperty("c2_nm")
    private String C2_NM;

    @JsonProperty("c2_nm_eng")
    private String C2_NM_ENG;

    @JsonProperty("c3_obj_nm")
    private String C3_OBJ_NM;

    @JsonProperty("c3_obj_nm_eng")
    private String C3_OBJ_NM_ENG;

    @JsonProperty("c3")
    private String C3;

    @JsonProperty("c3_nm")
    private String C3_NM;

    @JsonProperty("c3_nm_eng")
    private String C3_NM_ENG;

    @JsonProperty("itm_id")
    private String ITM_ID;

    @JsonProperty("itm_nm")
    private String ITM_NM;

    @JsonProperty("itm_nm_eng")
    private String ITM_NM_ENG;

    @JsonProperty("unit_id")
    private String UNIT_ID;

    @JsonProperty("unit_nm")
    private String UNIT_NM;

    @JsonProperty("unit_nm_eng")
    private String UNIT_NM_ENG;

    @JsonProperty("prd_se")
    private String PRD_SE;

    @JsonProperty("prd_de")
    private String PRD_DE;

    private String DT;

    @JsonProperty("clct_dt")
    private String clct_dt;
}


