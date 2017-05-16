package com.my.test.springbean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Chengfei.Sun
 */
@Component
@Scope("prototype")
public class AddressBean {
    public int index = 0;

    public void increaseIndex(){
        this.index = this.index + 1;
    }
}
