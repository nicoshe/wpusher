package com.nicos.wpusher.common;

public enum PushType {

    KAFKA("kafka");

    String desc;

    PushType(String desc) {
        this.desc = desc;
    }
}
