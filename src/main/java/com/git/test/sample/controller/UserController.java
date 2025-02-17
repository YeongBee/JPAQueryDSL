package com.git.test.sample.controller;

import com.git.test.sample.domain.UserEntity;
import com.git.test.sample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<UserEntity> index() {

        UserEntity user = UserEntity.builder()
//                .email("user3@example.com")
                .pw("password3")
                .build();
        UserEntity user2 = userService.testQueryDSL2(user);
        return ResponseEntity.ok(user2);
    }


}
