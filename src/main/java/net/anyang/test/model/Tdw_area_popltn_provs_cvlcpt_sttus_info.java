package net.anyang.test.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
/** 한눈에 보는 민원_지역 인구수 대비 민원현황 정보_안양시 데이터 **/
 public class Tdw_area_popltn_provs_cvlcpt_sttus_info {

   private Integer clct_sn;
   private Integer hits;
   private String label;
   private Integer population;
   private String ratio;
   private String mainsubcode;
   @JsonProperty("data_crtr_pnttm")
   private String data_crtr_pnttm;
   @JsonProperty("clct_dt")
   private String clct_dt;

}
