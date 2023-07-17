package com.nicos.wpusher.common.bo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsumeBOWrapper {

    private byte[] content;

    private String transportType;
}
