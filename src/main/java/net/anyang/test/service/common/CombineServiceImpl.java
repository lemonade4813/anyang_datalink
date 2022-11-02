package net.anyang.test.service.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class CombineServiceImpl implements CombineService {

    @Override
    public String makeUrl(String Url, String tb_nm, String ip, String port) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ip).append(":").append(port).append("/").append(Url).append("/").append(tb_nm);
        return stringBuilder.toString();
    }

    public List<Object> makeLists(String bodyJsonString) {
        Type listType = new TypeToken<List<Object>>(){}.getType();
        Gson gson = new Gson();
        List<Object> lists = gson.fromJson(bodyJsonString,listType);
        return lists;
    }


    @SneakyThrows
    public String makeClassName(String packageName, String tb_nm) {
        String[] packageArray = packageName.split("\\.");
        ArrayList<String> packageList = new ArrayList<>(Arrays.asList(packageArray));
        packageList.remove(packageList.size()-1);
        packageName = String.join(".",packageList);
        tb_nm = tb_nm.substring(0, 1).toUpperCase() + tb_nm.substring(1).toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageName).append(".model.").append(tb_nm);

        return stringBuilder.toString();
    }

}
