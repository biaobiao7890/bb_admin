package com.ma.bb.service.base.exception;

import com.ma.bb.common.base.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author biaob
 * @date 2020/10/02
 */
@Data
public class BbException extends RuntimeException {
    private Integer code;

    public BbException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BbException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "BbException{" +
                "code=" + code +
                "message=" + this.getMessage() +
                '}';
    }
}
