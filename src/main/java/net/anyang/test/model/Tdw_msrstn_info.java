package net.anyang.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
/**측정소 목록 조회*/
public class Tdw_msrstn_info {

    private Integer clct_sn;
    @JsonProperty("stationname")
    private String stationName;
    private String addr;
    private String year;
    @JsonProperty("mangname")
    private String mangName;
    private String item;
    @JsonProperty("dmx")
    private String dmX;
    @JsonProperty("dmy")
    private String dmY;
    @JsonProperty("data_crtr_pnttm")
    private String data_crtr_pnttm;
    @JsonProperty("clct_dt")
    private String clct_dt;

}
