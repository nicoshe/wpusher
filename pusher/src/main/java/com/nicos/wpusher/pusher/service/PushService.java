package com.nicos.wpusher.pusher.service;

import com.nicos.wpusher.common.bo.PushBO;
import com.nicos.wpusher.common.bo.PushBOWrapper;
import com.nicos.wpusher.common.req.PushRequest;
import com.nicos.wpusher.common.util.BeanCopierUtils;
import com.nicos.wpusher.pusher.config.PushProperties;
import com.nicos.wpusher.pusher.handler.PushHandlerFactory;
import com.nicos.wpusher.pusher.handler.PusherHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushService {

    @Autowired
    private PushHandlerFactory pushHandlerFactory;

    @Autowired
    private PushProperties pushConfig;

    public void push(PushRequest request) {
        PusherHandler pusherHandler = pushHandlerFactory.getPushHandler(pushConfig.getType());
        PushBO pushBO = new PushBO();
        BeanCopierUtils.copy(request, pushBO);
        PushBOWrapper wrapper = PushBOWrapper
                .builder()
                .content(pushBO)
                .transportType(pushConfig.getTransportType())
                .topic(pushConfig.getTopic())
                .build();
        pusherHandler.push(wrapper);
    }
}
