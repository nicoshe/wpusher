package com.nicos.wpusher.common.util;

import com.google.common.primitives.Bytes;
import com.nicos.wpusher.common.bo.ConsumeBOWrapper;

import java.util.ArrayList;
import java.util.List;

public class SerializationUtil {

    private static final SerializationUtil INSTANCE = new SerializationUtil();

    private final static String split = "\n";

    private SerializationUtil() {}

    public static SerializationUtil getInstance() {
        return INSTANCE;
    }

    public byte[] wrap(byte[] content, String transportType) {
        byte[] transTypeBytes = transportType.getBytes();
        byte[] splitBytes = split.getBytes();
        byte[] result = new byte[content.length + transTypeBytes.length + 1];

        System.arraycopy(transTypeBytes, 0, result, 0, transTypeBytes.length);
        System.arraycopy(splitBytes, transTypeBytes.length - 1, result, transTypeBytes.length - 1, 1);
        System.arraycopy(result, transTypeBytes.length, result, transTypeBytes.length, content.length);
        return result;
    }

    public ConsumeBOWrapper unWrap(byte[] content) {
        List<Byte> transTypeBytes = new ArrayList<>();
        for (byte aByte : content) {
            if (aByte == '\n') {
                break;
            }
            transTypeBytes.add(aByte);
        }
        int transTypeSize = transTypeBytes.size();
        // 1 为 split 长度
        byte[] result = new byte[content.length - transTypeSize - 1];

        System.arraycopy(content, transTypeSize, result, 0, content.length - transTypeSize - 1);
        return ConsumeBOWrapper.builder().content(result).transportType(new String(Bytes.toArray(transTypeBytes))).build();
    }
}
