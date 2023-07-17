package com.nicos.wpusher.consumer.consume;

import com.nicos.wpusher.common.bo.ConsumeBOWrapper;
import com.nicos.wpusher.common.bo.PushBOWrapper;
import com.nicos.wpusher.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class KafkaConsume {

    @Autowired
    private ConsumerService consumerService;

    @KafkaListener(topics = "push-message")
    public void consume(List<ConsumerRecord<String, byte[]>> records, Acknowledgment ack) {
        for (ConsumerRecord<String, byte[]> record : records) {
            byte[] value = record.value();
            log.info("分区: {}, offset: {}, content: {}", record.partition(), record.offset(), record.value());
            consumerService.doHandle(ConsumeBOWrapper.builder().content(value).build());
        }
        ack.acknowledge();
    }
}
