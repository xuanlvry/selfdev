package com.my.test.transaction.fenbushi.impl;

import com.my.test.AddressBookInfo;
import com.my.test.UserInfo;
import com.my.test.transaction.fenbushi.IFenbushiTransactionDemo;
import com.my.test.transaction.fenbushi.dao1.IUserInfoDAO;
import com.my.test.transaction.fenbushi.dao2.IAddressBookInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chengfei.Sun on 17/03/23.
 */
@Service
public class FenbushiTransactionDemo implements IFenbushiTransactionDemo {
    @Autowired
    IUserInfoDAO userInfoDAO;

    @Autowired
    IAddressBookInfoDAO addressBookInfoDAO;

    @Transactional
    public void test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(61);
        userInfo.setTel("134544bbbbbbbbbb");

        userInfoDAO.update(userInfo);

        AddressBookInfo addressBookInfo = new AddressBookInfo();
        addressBookInfo.setId(44058);
        addressBookInfo.setEmail("hahahabbbbbbbbbbbbb");

        addressBookInfoDAO.update(addressBookInfo);

//        System.out.println(1/0);
    }
}
