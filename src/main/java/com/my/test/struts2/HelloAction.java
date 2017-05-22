package com.my.test.struts2;

import com.my.test.IMyService;
import com.my.test.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Getter
    private UserInfo userInfo;

    @Autowired
    private IMyService myServiceImpl;

    public String execute() {
        this.name = "xiaoming";
        this.address = "上海";
        this.respCode = "232";
        this.respMessage = "成功";

        this.userInfo = myServiceImpl.selectUser(12);

        return SUCCESS;
    }

    public String getTel() {
        return "1347343";
    }
}
