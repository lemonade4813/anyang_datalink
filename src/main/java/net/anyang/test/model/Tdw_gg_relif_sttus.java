package net.anyang.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tdw_gg_relif_sttus {

    private Integer clct_sn;
    @JsonProperty("sigun_nm")
    private String SIGUN_NM;
    @JsonProperty("sigun_cd")
    private String SIGUN_CD;
    @JsonProperty("gout_firesttn_nm")
    private String GOUT_FIRESTTN_NM;
    @JsonProperty("gout_safe_center_nm")
    private String GOUT_SAFE_CENTER_NM;
    @JsonProperty("statmnt_ymd")
    private String STATMNT_YMD;
    @JsonProperty("statmnt_tm")
    private String STATMNT_TM;
    @JsonProperty("recept_cours")
    private String RECEPT_COURS;
    @JsonProperty("jurisd_div_nm")
    private String JURISD_DIV_NM;
    @JsonProperty("onspot_dstn")
    private Float ONSPOT_DSTN;
    @JsonProperty("homing_ymd")
    private String HOMING_YMD;
    @JsonProperty("homing_tm")
    private String HOMING_TM;
    @JsonProperty("patnt_age")
    private String PATNT_AGE;
    @JsonProperty("emrlf_sido_nm")
    private String EMRLF_SIDO_NM;
    @JsonProperty("patnt_sex_div_nm")
    private String PATNT_SEX_DIV_NM;
    @JsonProperty("rmrlf_signgu_nm")
    private String EMRLF_SIGNGU_NM;
    @JsonProperty("emrlf_emd_nm")
    private String EMRLF_EMD_NM;
    @JsonProperty("emrlf_li_nm")
    private String EMRLF_LI_NM;
    @JsonProperty("frgnr_yn")
    private String FRGNR_YN;
    @JsonProperty("natnlty_nm")
    private String NATNLTY_NM;
    @JsonProperty("relif_occurplc_type")
    private String RELIF_OCCURPLC_TYPE;
    @JsonProperty("patnt_symptms_type")
    private String PATNT_SYMPTMS_TYPE;
    @JsonProperty("relif_acdnt_asortmt_up_nm")
    private String RELIF_ACDNT_ASORTMT_UP_NM;
    @JsonProperty("relif_acdnt_asortmt_low_nm")
    private String RELIF_ACDNT_ASORTMT_LOW_NM;
    @JsonProperty("patnt_occur_type")
    private String PATNT_OCCUR_TYPE;
    @JsonProperty("conscs_state_type")
    private String CONSCS_STATE_TYPE;
    @JsonProperty("relif_sectchef_qualfctn_ratg")
    private String RELIF_SECTCHEF_QUALFCTN_RATG;
    @JsonProperty("amblncwkr_qualfctn_ratg")
    private String AMBLNCWKR_QUALFCTN_RATG;
    @JsonProperty("patnt_symptms_type2")
    private String PATNT_SYMPTMS_TYPE2;
    @JsonProperty("onspot_arvl_tm")
    private String ONSPOT_ARVL_TM;
    @JsonProperty("amblncwkr_ratg")
    private String AMBLNCWKR_RATG;
    @JsonProperty("gout_ymd")
    private String GOUT_YMD;
    @JsonProperty("gout_tm")
    private String GOUT_TM;
    @JsonProperty("onspot_arvl_ymd")
    private String ONSPOT_ARVL_YMD;
    @JsonProperty("sum_yy")
    private String SUM_YY;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;
}
