package com.nicos.wpusher.serialization;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.nicos.wpusher.common.TransportType;
import com.nicos.wpusher.common.bo.PushBO;
import org.springframework.stereotype.Component;

@Component
public class JSONSerialization extends AbstractSerialization {

    @Override
    public String getType() {
        return TransportType.JSON.name();
    }

    @Override
    protected <T> T doSerialize(byte[] content, Class<T> clazz) {
        return JSONObject.parseObject(new String(content), clazz);
    }

    @Override
    public byte[] doSerialize(PushBO content) {
        return JSON.toJSONBytes(content);
    }
}
