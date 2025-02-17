package com.git.test.sample.service;

import com.git.test.sample.domain.QUserEntity;
import com.git.test.sample.domain.UserEntity;
import com.git.test.sample.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public void initUser() {

        userRepository.save(new UserEntity(null, "user1@example.com", "password1"));
        userRepository.save(new UserEntity(null, "user2@example.com", "password2"));
        userRepository.save(new UserEntity(null, "user3@example.com", "password3"));
        userRepository.save(new UserEntity(null, "user4@example.com", "password4"));
        userRepository.save(new UserEntity(null, "user5@example.com", "password5"));
    }

    @Override
    public UserEntity testQueryDSL(String email) {
        QUserEntity qUserEntity = QUserEntity.userEntity;
//        return jpaQueryFactory.selectFrom(qUserEntity)
//                .where(qUserEntity.email.eq(email))
//                .fetchOne();

        return Optional.ofNullable(
                        jpaQueryFactory.selectFrom(qUserEntity)
                                .where(qUserEntity.email.eq(email))
                                .fetchOne())
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + email));
    }

    @Override
    public UserEntity testQueryDSL2(UserEntity userEntity) {
        return userRepository.myFindByEmail(userEntity);
    }

}
