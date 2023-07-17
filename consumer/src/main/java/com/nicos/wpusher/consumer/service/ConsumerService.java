package com.nicos.wpusher.consumer.service;

import com.nicos.wpusher.common.bo.ConsumeBOWrapper;
import com.nicos.wpusher.common.bo.PushBO;
import com.nicos.wpusher.common.util.SerializationUtil;
import com.nicos.wpusher.consumer.config.ConsumerProperties;
import com.nicos.wpusher.consumer.handler.ConsumerHandler;
import com.nicos.wpusher.consumer.handler.ConsumerHandlerFactory;
import com.nicos.wpusher.serialization.Serialization;
import com.nicos.wpusher.serialization.SerializationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerHandlerFactory consumerHandlerFactory;

    @Autowired
    private ConsumerProperties consumerProperties;

    @Autowired
    private SerializationFactory serializationFactory;

    /**
     * 统一处理消费消息
     * @param contentWrapper
     */
    public void doHandle(ConsumeBOWrapper contentWrapper) {
        contentWrapper = SerializationUtil.getInstance().unWrap(contentWrapper.getContent());
        Serialization serialization = serializationFactory.getSerialization(contentWrapper.getTransportType());
        PushBO pushBO = serialization.deserialize(contentWrapper, PushBO.class);
        ConsumerHandler consumerHandler = consumerHandlerFactory.getConsumerHandler(consumerProperties.getType());
        consumerHandler.handle(pushBO);
    }
}
