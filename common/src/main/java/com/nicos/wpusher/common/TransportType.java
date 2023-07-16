package com.nicos.wpusher.common;

public enum TransportType {
    JSON("json");

    String desc;

    TransportType(String desc) {
        this.desc = desc;
    }
}
