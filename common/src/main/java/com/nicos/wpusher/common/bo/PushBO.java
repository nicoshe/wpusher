package com.nicos.wpusher.common.bo;

import lombok.Data;

@Data
public class PushBO {

    /**
     * 全局唯一ID 系统自动生成
     */
    private String id;

    /**
     * 推送内容
     */
    private String content;

    /**
     * 谁发送的
     */
    private String fromId;

    /**
     * 推送给谁
     */
    private String toId;

    /**
     * 推送类型
     */
    private String type;
}
