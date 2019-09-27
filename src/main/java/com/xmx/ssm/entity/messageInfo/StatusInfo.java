package com.xmx.ssm.entity.messageInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StatusInfo {
    private Integer status = 200;
    private String message;
}
