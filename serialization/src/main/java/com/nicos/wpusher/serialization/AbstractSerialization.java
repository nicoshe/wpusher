package com.nicos.wpusher.serialization;

import com.nicos.wpusher.common.bo.ConsumeBOWrapper;
import com.nicos.wpusher.common.bo.PushBO;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSerialization implements Serialization {

    @Override
    public byte[] serialize(PushBO content) {
        return doSerialize(content);
    }

    @Override
    public <T> T deserialize(ConsumeBOWrapper contentWrapper, Class<T> clazz) {
        return doSerialize(contentWrapper.getContent(), clazz);
    }

    protected abstract <T> T doSerialize(byte[] content, Class<T> clazz);

    protected abstract byte[] doSerialize(PushBO content);
}
