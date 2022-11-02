package net.anyang.test.service.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface CombineService {
    public String makeUrl(String Url, String tb_nm, String ip, String port);

    public List<Object> makeLists(String bodyJsonString);

    public String makeClassName(String packageName,String tb_nm) ;
}
