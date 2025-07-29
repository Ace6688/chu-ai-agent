package com.qiaochu.chuaiagent.controller;

import com.qiaochu.chuaiagent.common.BaseResponse;
import com.qiaochu.chuaiagent.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MainController {

    @GetMapping("/health")
    public BaseResponse<String> health(){
        return ResultUtils.success("ok");
    }

}
