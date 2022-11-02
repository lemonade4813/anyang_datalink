package net.anyang.test.service.common;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.io.*;


@Slf4j
@CrossOrigin
@Service
public class FindServiceImpl implements FindService {

    @Override
    public JsonArray findParam(Long dtst_sn, String paramNm) throws IOException {
        String dtstSn = Long.toString(dtst_sn);

        InputStream inputStream = new ClassPathResource("params.json").getInputStream();
        File file =File.createTempFile("params",".json");
        try {
            FileUtils.copyInputStreamToFile(inputStream, file);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        Reader reader = new FileReader(file);
        JsonObject jsonResult = new JsonParser().parse(reader).getAsJsonObject();
        return jsonResult.get(dtstSn).getAsJsonObject().get(paramNm).getAsJsonArray();
    }

    @Override
    public String findParamNm(Long dtst_sn) throws IOException {
        String dtstSn = Long.toString(dtst_sn);
        InputStream inputStream = new ClassPathResource("params.json").getInputStream();
        File file = File.createTempFile("params",".json");
        try {
            FileUtils.copyInputStreamToFile(inputStream, file);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        Reader reader = new FileReader(file);
        JsonObject jsonResult = new JsonParser().parse(reader).getAsJsonObject();
        return jsonResult.get(dtstSn).getAsJsonObject().get("paramNm").getAsString();
    }

    @Override
    public String findJsonDivide(Long dtst_sn) throws IOException {
        String dtstSn = Long.toString(dtst_sn);
        InputStream inputStream = new ClassPathResource("params.json").getInputStream();
        File file =File.createTempFile("params",".json");
        try {
            FileUtils.copyInputStreamToFile(inputStream, file);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        Reader reader = new FileReader(file);
        JsonObject jsonResult = new JsonParser().parse(reader).getAsJsonObject();
        return jsonResult.get(dtstSn).getAsJsonObject().get("jsonDivide").getAsString();
    }

    @Override
    public String findDateNm(Long dtst_sn) throws IOException {
        String dtstSn = Long.toString(dtst_sn);
        InputStream inputStream = new ClassPathResource("params.json").getInputStream();
        File file =File.createTempFile("params",".json");
        try {
            FileUtils.copyInputStreamToFile(inputStream, file);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        Reader reader = new FileReader(file);
        JsonObject jsonResult = new JsonParser().parse(reader).getAsJsonObject();
        return jsonResult.get(dtstSn).getAsJsonObject().get("dataName").getAsString();
    }

}
