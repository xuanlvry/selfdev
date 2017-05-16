package com.my.test.common.constants;

import com.my.test.common.enums.CommonResponseCodes;

/**
 * @author Chengfei.Sun on 16/11/14.
 */
public class ServiceResponse {
    private String code;
    private String message;
    private Object object;

    public ServiceResponse() {
        this.code = CommonResponseCodes.Success.getCode();
        this.message = CommonResponseCodes.Success.getMessage();
    }

    public ServiceResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setResponse(CommonResponseCodes commonResponseCodes) {
        this.code = commonResponseCodes.getCode();
        this.message = commonResponseCodes.getMessage();
    }

    public void setResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
