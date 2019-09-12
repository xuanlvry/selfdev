package com.sun.dev.dao.springdatajpa;

import com.sun.dev.service.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sunchengfei on 2018/4/4.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    List<UserInfo> findByAge(int age);
}