package com.nicos.wpusher.pusher.handler;

import com.nicos.wpusher.common.bo.PushBO;
import com.nicos.wpusher.common.bo.PushBOWrapper;

public interface PusherHandler {

    /**
     * 当前的推送类型
     * @return
     */
    String getType();

    void push(PushBOWrapper push);
}
