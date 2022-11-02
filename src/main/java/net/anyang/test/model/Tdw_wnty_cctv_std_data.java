package net.anyang.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tdw_wnty_cctv_std_data {

    private Integer clct_sn;
    @JsonProperty("institutionnm")
    private String institutionNm;
    private String rdnmadr;
    private String lnmadr;
    @JsonProperty("installationpurpstype")
    private String installationPurpsType;
    @JsonProperty("cctvnumber")
    private String cctvNumber;
    @JsonProperty("cctvpixel")
    private String cctvPixel;
    @JsonProperty("potogrfinfo")
    private String potogrfInfo;
    @JsonProperty("cstdyday")
    private String cstdyDay;
    @JsonProperty("installationyymm")
    private String installationYymm;
    @JsonProperty("phonenumber")
    private String phoneNumber;
    private String latitude;
    private String longitude;
    @JsonProperty("referencedate")
    private String referenceDate;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}
