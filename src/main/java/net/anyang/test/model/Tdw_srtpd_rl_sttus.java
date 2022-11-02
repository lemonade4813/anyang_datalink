package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/** 기상청_단기예보 조회서비스 - 초단기실황조회 **/
public class Tdw_srtpd_rl_sttus {

    @JsonProperty("basedate")
    private String baseDate;
    @JsonProperty("basetime")
    private String baseTime;
    @JsonProperty("category")
    private String category;
    @JsonProperty("nx")
    private Integer nx;
    @JsonProperty("ny")
    private Integer ny;
    @JsonProperty("obsrvalue")
    private String obsrValue;
}
