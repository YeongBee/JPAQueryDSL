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
        UserEntity user = userService.testQueryDSL("user4@example.com");
        return ResponseEntity.ok(user);
    }


}
