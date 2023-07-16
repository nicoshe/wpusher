package com.nicos.wpusher.pusher.handler;

import com.nicos.wpusher.common.PushType;
import com.nicos.wpusher.common.bo.PushBO;
import com.nicos.wpusher.common.bo.PushBOWrapper;
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
        Serialization serialization = serializationFactory.getSerialization(push.getTransportType());
        PushBO pushBO = push.getContent();
        byte[] content = serialization.serialize(push.getContent());
        kafkaTemplate.send(push.getTopic(), pushBO.getId(), content);
    }
}
