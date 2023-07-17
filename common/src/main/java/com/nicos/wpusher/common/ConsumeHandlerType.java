package com.nicos.wpusher.common;

public enum ConsumeHandlerType {

    HBASE("HBase");

    String desc;

    ConsumeHandlerType(String desc) {
        this.desc = desc;
    }
}
