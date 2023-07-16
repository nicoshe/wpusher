package com.nicos.wpusher.common.bo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PushBOWrapper {

    private PushBO content;

    private String transportType;

    private String topic;
}
