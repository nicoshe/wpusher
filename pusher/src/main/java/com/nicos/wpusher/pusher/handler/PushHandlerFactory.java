package com.nicos.wpusher.pusher.handler;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

@Service
public class PushHandlerFactory {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, PusherHandler> type2PusherHandler = new HashMap<>();

    public PushHandlerFactory() {
        Map<String, PusherHandler> map = applicationContext.getBeansOfType(PusherHandler.class);
        for (PusherHandler pusherHandler : map.values()) {
            type2PusherHandler.put(pusherHandler.getType(), pusherHandler);
        }
    }

    public PusherHandler getPushHandler(String type) {
        Preconditions.checkArgument(!StringUtils.isEmpty(type), "type is required");
        type = type.toUpperCase();
        return type2PusherHandler.get(type);
    }
}
