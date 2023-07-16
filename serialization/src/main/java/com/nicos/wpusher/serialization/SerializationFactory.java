package com.nicos.wpusher.serialization;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

@Component
public class SerializationFactory {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, Serialization> type2Serialization = new HashMap<>();

    public SerializationFactory() {
        Map<String, Serialization> serializationMap = applicationContext.getBeansOfType(Serialization.class);
        for (Serialization serialization : serializationMap.values()) {
            type2Serialization.put(serialization.getType(), serialization);
        }
    }

    public Serialization getSerialization(String transportType) {
        Preconditions.checkArgument(!StringUtils.isEmpty(transportType), "transportType is required config");
        Serialization serialization = type2Serialization.get(transportType);
        Preconditions.checkNotNull(serialization, "cant not support current Serialization");
        return serialization;
    }
}
