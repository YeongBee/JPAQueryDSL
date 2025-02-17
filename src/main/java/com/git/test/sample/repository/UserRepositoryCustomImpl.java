package com.git.test.sample.repository;

import com.git.test.sample.domain.QUserEntity;
import com.git.test.sample.domain.UserEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;


@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public UserEntity myFindByEmail(UserEntity userEntity) {
        QUserEntity user = QUserEntity.userEntity;

        return queryFactory
                .selectFrom(user)
                .where(hasEmail(userEntity.getEmail()),
                        hasPw(userEntity.getPw()))
                .fetchOne();
    }

    private BooleanExpression hasEmail(String emailGoe){
        return StringUtils.hasText(emailGoe) ? QUserEntity.userEntity.email.eq(emailGoe):null;
    }

    private BooleanExpression hasPw(String pwdGoe){
        return StringUtils.hasText(pwdGoe) ? QUserEntity.userEntity.pw.eq(pwdGoe):null;
    }
}
