package net.anyang.test.service;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.anyang.test.model.ApiInterface;
import net.anyang.test.service.common.GetDateService;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

@Slf4j
@Service
public class KosisService {
    @Autowired
    ApiInterface apiInterface;

    @Autowired
    GetDateService getDateService;

    public <T> T createObject(String jsonitem, Class<T> clazz) {
        return new Gson().fromJson(jsonitem,clazz);
    }

    public JsonArray getJsonResult(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        log.info(url);
        ResponseBody responseBody = apiInterface.getUrl(sb.toString()).execute().body();
        String jsonString = responseBody.string();
        JsonArray jsonResult = new JsonParser().parse(jsonString).getAsJsonArray();
        return jsonResult;
    }


    public boolean downLoad(final File output, final String source){
        try {
            if (!output.createNewFile()) {
                throw new RuntimeException("Could not create new file!");
            }
            URL url = new URL(source);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("AUTH-KEY-PROPERTY-NAME", "yourAuthKey");
            final ReadableByteChannel rbc = Channels.newChannel(connection.getInputStream());
            final FileOutputStream fos = new FileOutputStream(output);
            fos.getChannel().transferFrom(rbc, 0, 1 << 24);
            fos.close();
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String selectFileName(String Url){
        int a = Url.indexOf("101") +4;
        int b = Url.indexOf("/",a );
        return Url.substring(a,b);
    }

    public String findPath(String path,String Url){
        StringBuilder sb = new StringBuilder();
        sb.append(path).append("/").append(getDateService.getBeforeMonth())
                .append("/").append(this.selectFileName(Url))
                .append(".xls");
        return sb.toString();
    }

    public JsonObject appendColum(JsonObject jsonObj) throws IOException{
        jsonObj.addProperty("clct_dt",getDateService.getNowDay());
        return jsonObj;
    }



}
