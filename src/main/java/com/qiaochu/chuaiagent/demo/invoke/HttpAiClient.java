package com.qiaochu.chuaiagent.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

public class HttpAiClient {
    private static final String API_URL = "https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions";
    private final String apiKey;

    public HttpAiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String chat(String userMessage) {
        // 构建请求体JSON
        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "qwen-plus");
        
        JSONArray messages = new JSONArray();
        
        // 添加system消息
        JSONObject systemMessage = new JSONObject();
        systemMessage.put("role", "system");
        systemMessage.put("content", "You are a helpful assistant.");
        messages.add(systemMessage);
        
        // 添加user消息
        JSONObject userMsgObj = new JSONObject();
        userMsgObj.put("role", "user");
        userMsgObj.put("content", userMessage);
        messages.add(userMsgObj);
        
        requestBody.put("messages", messages);
        
        // 发送HTTP请求
        HttpResponse response = HttpRequest.post(API_URL)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .execute();
        
        // 处理响应
        if (response.isOk()) {
            return response.body();
        } else {
            throw new RuntimeException("API请求失败，状态码：" + response.getStatus() + 
                                      "，响应内容：" + response.body());
        }
    }

    public static void main(String[] args) {
        // 从环境变量获取API密钥或直接指定

        HttpAiClient client = new HttpAiClient(TestApiKey.API_KEY);
        
        // 发送测试请求
        String result = client.chat("你是谁？");
        System.out.println("API响应：" + result);
    }
}