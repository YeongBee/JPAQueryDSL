package com.git.test.sample.service;

import com.git.test.sample.domain.UserEntity;

public interface UserService {

    void initUser();
    UserEntity testQueryDSL(String email);
}
