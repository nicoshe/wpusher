package com.nicos.wpusher.serialization;

import com.alibaba.fastjson2.JSON;
import com.nicos.wpusher.common.TransportType;
import com.nicos.wpusher.common.bo.PushBO;
import org.springframework.stereotype.Component;

@Component
public class JSONSerialization implements Serialization {

    @Override
    public String getType() {
        return TransportType.JSON.name();
    }

    @Override
    public byte[] serialize(PushBO content) {
        return JSON.toJSONBytes(content);
    }
}
