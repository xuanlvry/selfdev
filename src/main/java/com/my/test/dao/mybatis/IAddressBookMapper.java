package com.my.test.dao.mybatis;

import com.my.test.AddressBookInfo;

/**
 * @author Chengfei.Sun on 17/02/07.
 */
public interface IAddressBookMapper {
    Integer insert(AddressBookInfo bookInfo);

    Integer update(AddressBookInfo bookInfo);
}
