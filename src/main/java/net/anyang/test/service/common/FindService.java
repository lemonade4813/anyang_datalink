package net.anyang.test.service.common;

import com.google.gson.JsonArray;

import javax.annotation.Nullable;
import java.io.IOException;

public interface FindService {
    public JsonArray findParam(Long dtst_sn, String paramNm) throws IOException;
    public String findParamNm(Long dtst_sn)throws IOException;
    public String findJsonDivide(Long dtst_sn)throws IOException;
    public String findDateNm(Long dtst_sn)throws IOException;
}
