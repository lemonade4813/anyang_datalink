package net.anyang.test.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*** 법규위반별 사고다발지역정보 ***/
 public class Tdw_lrg_violt_accto_acdnt_mlttd_area_info {

   private Integer clct_sn;
   private Integer afos_fid;
   private String afos_id;
   private String bjd_cd;
   private String spot_cd;
   private String sido_sgg_nm;
   private String spot_nm;
   private Integer occrrnc_cnt;
   private Integer caslt_cnt;
   private Integer dth_dnv_cnt;
   private Integer se_dnv_cnt;
   private Integer sl_dnv_cnt;
   private Integer wnd_dnv_cnt;
   private String lo_crd;
   private String la_crd;
   private String geom_json;
   private String data_crtr_pnttm;
   private String clct_dt;
}
