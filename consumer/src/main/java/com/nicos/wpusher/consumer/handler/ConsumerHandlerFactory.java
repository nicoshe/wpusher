package com.nicos.wpusher.consumer.handler;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsumerHandlerFactory {

    @Autowired
    private ApplicationContext applicationContext;

    private final Map<String, ConsumerHandler> type2ConsumerHandler = new HashMap<>();

    public ConsumerHandlerFactory() {
        Map<String, ConsumerHandler> consumerHandlerMap = applicationContext.getBeansOfType(ConsumerHandler.class);
        for (ConsumerHandler consumerHandler : consumerHandlerMap.values()) {
            type2ConsumerHandler.put(consumerHandler.getType(), consumerHandler);
        }
    }

    public ConsumerHandler getConsumerHandler(String type) {
        Preconditions.checkArgument(!StringUtils.isEmpty(type), "type is required config");
        ConsumerHandler consumerHandler = type2ConsumerHandler.get(type);
        Preconditions.checkNotNull(consumerHandler);
        return consumerHandler;
    }
}
