package com.sun.dev.dao.mybatis;

import com.sun.dev.service.AddressBookInfo;

/**
 * @author Chengfei.Sun on 17/02/07.
 */
public interface IAddressBookMapper {
    Integer insert(AddressBookInfo bookInfo);

    Integer update(AddressBookInfo bookInfo);
}
