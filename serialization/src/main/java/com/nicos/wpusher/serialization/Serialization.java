package com.nicos.wpusher.serialization;

import com.nicos.wpusher.common.bo.ConsumeBOWrapper;
import com.nicos.wpusher.common.bo.PushBO;

public interface Serialization {

    /**
     * 获取传输类型
     * @return
     */
    String getType();

    byte[] serialize(PushBO content);

    <T> T deserialize(ConsumeBOWrapper contentWrapper, Class<T> clazz);
}
