package com.nicos.wpusher.consumer.handler;

import com.nicos.wpusher.common.bo.PushBO;

public abstract class AbstractConsumerHandler implements ConsumerHandler {

    @Override
    public void handle(PushBO pushBO) {
        // 先记录缓存
        // 调用子类实现
        doHandle(pushBO);
    }

    protected abstract void doHandle(PushBO pushBO);
}
