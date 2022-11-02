package net.anyang.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;
/**측정소별 실시간 측정정보_시간별 **/
@Getter
@Setter
public class Tdw_arpltn_msrstn_rltm_mesure_info_hour{


    @JsonProperty("datatime")
    private String dataTime;
    @JsonProperty("stationname")
    private String stationName;
    @JsonProperty("so2value")
    private String so2Value;
    @JsonProperty("covalue")
    private String coValue;
    @JsonProperty("o3value")
    private String o3Value;
    @JsonProperty("no2value")
    private String no2Value;
    @JsonProperty("pm10value")
    private String pm10Value;
    @JsonProperty("pm25value")
    private String pm25Value;
    @JsonProperty("khaivalue")
    private String khaiValue;
    @JsonProperty("khaigrade")
    private String khaiGrade;
    @JsonProperty("so2grade")
    private String so2Grade;
    @JsonProperty("cograde")
    private String coGrade;
    @JsonProperty("o3grade")
    private String o3Grade;
    @JsonProperty("no2grade")
    private String no2Grade;
    @JsonProperty("pm10grade")
    private String pm10Grade;
    @JsonProperty("pm25grade")
    private String pm25Grade;
    @JsonProperty("so2flag")
    private String so2Flag;
    @Nullable
    @JsonProperty("coflag")
    private String coFlag;
    @Nullable
    @JsonProperty("o3flag")
    private String o3Flag;
    @Nullable
    @JsonProperty("no2flag")
    private String no2Flag;
    @Nullable
    @JsonProperty("pm10flag")
    private String pm10Flag;
    @Nullable
    @JsonProperty("pm25flag")
    private String pm25Flag;
    @Nullable
    @JsonProperty("mangname")
    private String mangName;
    @Nullable
    @JsonProperty("pm10grade1h")
    private String pm10Grade1h;
    @Nullable
    @JsonProperty("pm25grade1h")
    private String pm25Grade1h;
    @Nullable
    @JsonProperty("pm25value24")
    private String pm25Value24;
    @Nullable
    @JsonProperty("pm10value24")
    private String pm10Value24;

}
