package com.my.test.struts2;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by sunchengfei on 2017/5/19.
 */
public class HelloAction extends ActionSupport {
    @Getter
    @Setter
    private String name;

    @Getter
    private String address;

    private String respCode;

    private String respMessage;

    public String execute() {
        this.name = "xiaoming";
        this.address = "上海";
        this.respCode = "232";
        this.respMessage = "成功";

        return SUCCESS;
    }

    public String getTel() {
        return "1347343";
    }
}
