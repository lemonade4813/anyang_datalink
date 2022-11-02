package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;

@Getter
@Setter
/*** 지역화폐 발행 및 이용현황 ***/
public class Tdw_area_crrncy_pblcn_nd_use_sttus {

    private Integer clct_sn;
    @JsonProperty("sigun_cd")
    private String SIGUN_CD;
    @JsonProperty("sigun_nm")
    private String SIGUN_NM;
    @JsonProperty("std_ym")
    private String STD_YM;
    @JsonProperty("card_publct_cnt")
    private Integer CARD_PUBLCT_CNT;
    @Nullable
    @JsonProperty("card_chrgng_amt")
    private Integer CARD_CHRGNG_AMT;
    @Nullable
    @JsonProperty("card_use_amt")
    private Integer CARD_USE_AMT;
    @Nullable
    @JsonProperty("mobile_giftcertf_user_cnt")
    private Integer MOBILE_GIFTCERTF_USER_CNT;
    @Nullable
    @JsonProperty("mobile_chrgng_amt")
    private Integer MOBILE_CHRGNG_AMT;
    @Nullable
    @JsonProperty("mobile_use_amt")
    private Integer MOBILE_USE_AMT;
    @JsonProperty("brnhstrm_giftcertf_sale_amt")
    private Integer BRNHSTRM_GIFTCERTF_SALE_AMT;
    @JsonProperty("brnhstrm_gifrcertf_retrvl_amy")
    private Integer BRNHSTRM_GIFTCERTF_RETRVL_AMT;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}
