package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Nullable;
import java.util.Date;

@Getter
@Setter
/*** 기상관측 시간자료 ***/
public class Tdw_wether_hr_data {

    private Integer clct_sn;
    @JsonProperty("stnid")
    private String stnId;
    private String  tm;
    @JsonProperty("stnnm")
    private String stnNm;
    private String rnum;
    @JsonProperty("m03te")
    private String m03Te;
    @JsonProperty("m02te")
    private String m02Te;
    @JsonProperty("m01te")
    private String m01Te;
    @JsonProperty("m005te")
    private String m005Te;
    private String ts;
    @JsonProperty("dmstmtphno")
    private String dmstMtphNo;
    @JsonProperty("gndsttcd")
    private String gndSttCd;
    private String vs;
    @JsonProperty("lcsch")
    private String lcsCh;
    @JsonProperty("clfmabbrcd")
    private String clfmAbbrCd;
    @JsonProperty("dc10lmcsca")
    private String dc10LmcsCa;
    @JsonProperty("dc10tca")
    private String dc10Tca;
    @JsonProperty("hr3fhsc")
    private String hr3Fhsc;
    private String dsnw;
    private String icsr;
    private String ss;
    private String ps;
    private String pa;
    private String td;
    private String pv;
    private String hm;
    private String wd;
    private String ws;
    private String rn;
    private String ta;
    @JsonProperty("rnqcflg")
    private String rnQcflg;
    @JsonProperty("ssqcflg")
    private String ssQcflg;
    @JsonProperty("hmqcflg")
    private String hmQcflg;
    @JsonProperty("tsqcflg")
    private String tsQcflg;
    @JsonProperty("psqcflg")
    private String psQcflg;
    @JsonProperty("taqcflg")
    private String taQcflg;
    @JsonProperty("wsqcflg")
    private String wsQcflg;
    @JsonProperty("wdqcflg")
    private String wdQcflg;
    @JsonProperty("paqcflg")
    private String paQcflg;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;
}
