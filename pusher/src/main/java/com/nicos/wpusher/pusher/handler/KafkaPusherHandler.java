package com.nicos.wpusher.pusher.handler;

import com.nicos.wpusher.common.PushType;
import com.nicos.wpusher.common.bo.PushBO;
import com.nicos.wpusher.common.bo.PushBOWrapper;
import com.nicos.wpusher.common.util.SerializationUtil;
import com.nicos.wpusher.serialization.Serialization;
import com.nicos.wpusher.serialization.SerializationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPusherHandler implements PusherHandler {

    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    @Autowired
    private SerializationFactory serializationFactory;

    @Override
    public String getType() {
        return PushType.KAFKA.name();
    }

    @Override
    public void push(PushBOWrapper push) {
        PushBO pushBO = push.getContent();
        Serialization serialization = serializationFactory.getSerialization(pushBO.getTransportType());
        byte[] content = serialization.serialize(pushBO);
        byte[] contentWrapper = SerializationUtil.getInstance().wrap(content, pushBO.getTransportType());
        kafkaTemplate.send(push.getTopic(), pushBO.getId(), contentWrapper);
    }
}
