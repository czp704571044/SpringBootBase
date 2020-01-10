package com.czp.demo.Util;

import lombok.Data;

@Data
public class ReturnJson {
    private String message;
    private Object object;
    private Integer state;
    private Integer code;
    private Integer rollback;
}
