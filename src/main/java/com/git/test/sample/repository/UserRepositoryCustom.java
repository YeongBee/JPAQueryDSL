package com.git.test.sample.repository;

import com.git.test.sample.domain.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserRepositoryCustom {

    UserEntity myFindByEmail(UserEntity email);
}
