package com.example.marathon.api;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.marathon.common.MarathonUtil;
import com.example.marathon.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.*;
import org.apache.http.entity.ContentType;

import java.util.List;
import java.util.Base64;
import java.io.IOException;

@Slf4j
public class GitHubUpdateData {
    public static String getFileData(String filename) {
        try {
            String response = Request.Get(String.format("%s/%s", MarathonUtil.getGithubJsonPath(), filename))
                    .addHeader("Authorization", String.format("token %s", MarathonUtil.getGithubToken()))
                    .execute().returnContent().asString();
            return JSONObject.parseObject(response).getString("sha");
        }
        catch (IOException e) { System.out.println(e); }
        return null;
    }

    public static <T> boolean sendUpdateRequest(String filename, List<T> data) {
        // 查询历史文件的 sha
        String sha = getFileData(filename);
        
        // 定义时间格式查询数据
        JSONObject.DEFFAULT_DATE_FORMAT="HH:mm:ss";
        String content = JSON.toJSONString(Result.ok(data),
                SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);

        // 创建请求数据结构
        JSONObject json = new JSONObject();
        json.put("sha", sha);
        json.put("message", "更新数据");
        json.put("content", Base64.getEncoder().encodeToString(content.getBytes()));
        try {
            String request = Request.Put(String.format("%s/%s", MarathonUtil.getGithubJsonPath(), filename))
                    .addHeader("Authorization", String.format("token %s", MarathonUtil.getGithubToken()))
                    .addHeader("Content-Type", "application/json; charset=utf-8")
                    .bodyString(json.toJSONString(), ContentType.APPLICATION_JSON)
                    .execute().returnContent().asString();
            JSONObject response = JSON.parseObject(request).getJSONObject("content");
            log.info("file: {}  size: {}", response.getString("name"), response.getIntValue("size"));
            return response.getIntValue("size") > 0;
        }
        catch (IOException e) { System.out.println(e); }
        return false;
    }

}
