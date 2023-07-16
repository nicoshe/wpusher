package com.nicos.wpusher.pusher.controller;

import com.nicos.wpusher.common.req.PushRequest;
import com.nicos.wpusher.common.resp.Result;
import com.nicos.wpusher.common.resp.Void;
import com.nicos.wpusher.pusher.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class PushController {

    @Autowired
    private PushService pushService;

    /**
     * 推送消息
     * @param request
     * @return
     */
    @PostMapping("/push")
    public Result<Void> push(@Validated @RequestBody PushRequest request) {
        pushService.push(request);
        return Result.success();
    }
}
