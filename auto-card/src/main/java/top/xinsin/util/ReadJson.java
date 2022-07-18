package top.xinsin.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created On 7/11/22 8:04 AM
 *
 * @author xinsin
 * @version 1.0.0
 */
public class ReadJson {
    public static JSONObject readJson(File file) throws IOException {
        return JSON.parseObject(FileUtils.readFileToString(file, "UTF-8"));
    }

    public static List<String> readCards(JSONObject jsonObject){
        JSONArray cards = jsonObject.getJSONArray("cards");
        return cards.toList(String.class);
    }

    public static Integer readTotal(JSONObject jsonObject){
        return jsonObject.getInteger("total");
    }

    public static Integer readCount(JSONObject jsonObject){
        return jsonObject.getInteger("count");
    }

    public static void writeCount(JSONObject jsonObject,File file) throws IOException {
        jsonObject.put("count", jsonObject.getInteger("count") + 1);
        FileUtils.writeStringToFile(file, jsonObject.toJSONString(), "UTF-8");

    }
    public static JSONObject writeTotal(JSONObject jsonObject,File file) throws IOException {
        jsonObject.put("total", jsonObject.getJSONArray("cards").size());
        FileUtils.writeStringToFile(file, jsonObject.toJSONString(), "UTF-8");
        return jsonObject;
    }
}
