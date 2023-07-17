package com.nicos.wpusher.consumer.handler;

import com.nicos.wpusher.common.ConsumeHandlerType;
import com.nicos.wpusher.common.bo.PushBO;
import org.springframework.stereotype.Service;

/**
 * 将消息存储到 hbase 中
 */
@Service
public class HBaseConsumerHandler extends AbstractConsumerHandler {

    @Override
    public String getType() {
        return ConsumeHandlerType.HBASE.name();
    }

    @Override
    public void doHandle(PushBO pushBO) {

    }
}
