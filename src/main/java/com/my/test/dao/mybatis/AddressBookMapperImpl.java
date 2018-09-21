package com.my.test.dao.mybatis;

import com.my.test.AddressBookInfo;
import org.springframework.stereotype.Component;

/**
 * Created by sunchengfei on 2018/6/1.
 */
@Component
public class AddressBookMapperImpl implements IAddressBookMapper {
    @Override
    public Integer insert(AddressBookInfo bookInfo) {
        System.out.println("调用AddressBookMapperImpl insert方法");
        return null;
    }

    @Override
    public Integer update(AddressBookInfo bookInfo) {
        System.out.println("调用AddressBookMapperImpl update方法");
        return null;
    }
}
