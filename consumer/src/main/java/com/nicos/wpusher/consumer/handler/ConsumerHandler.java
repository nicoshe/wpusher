package com.nicos.wpusher.consumer.handler;

import com.nicos.wpusher.common.bo.PushBO;

public interface ConsumerHandler {

    String getType();

    void handle(PushBO pushBO);
}
