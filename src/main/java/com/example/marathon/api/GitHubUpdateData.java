package com.example.marathon.api;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.marathon.common.MarathonUtil;
import com.example.marathon.common.Result;
import org.apache.http.client.fluent.*;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Base64;
import java.io.IOException;

public class GitHubUpdateData {
    public static String getFileData(String filename) {
        try {
            Content content = Request.Get(MarathonUtil.getGithubJsonPath() + filename)
                    .addHeader("Authorization", "token " + MarathonUtil.getGithubToken())
                    .execute().returnContent();
            return JSONObject.parseObject(content.toString()).getString("sha");
        }
        catch (IOException e) { System.out.println(e); }
        return null;
    }

    public static <T> void sendUpdateRequest(String filename, List<T> data) {
        // 查询历史文件的 sha
        String sha = getFileData(filename);

        // 定义时间格式查询数据
        JSONObject.DEFFAULT_DATE_FORMAT="HH:mm:ss";
        Result result = Result.ok(data);
        String content = JSON.toJSONString(result, SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);

        // 创建请求数据结构
        JSONObject json = new JSONObject();
        json.put("sha", sha);
        json.put("message", "更新数据");
        json.put("content", Base64.getEncoder().encodeToString(content.getBytes()));
        try {
            Content request = Request.Put(MarathonUtil.getGithubJsonPath() + filename)
                    .addHeader("Authorization", "token " + MarathonUtil.getGithubToken())
                    .addHeader("Content-Type", "application/json; charset=utf-8")
                    .bodyString(json.toJSONString(), ContentType.APPLICATION_JSON)
                    .execute().returnContent();
            System.out.println(request);
        }
        catch (IOException e) { System.out.println(e); }
    }

}
