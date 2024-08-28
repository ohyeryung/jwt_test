package com.smile.jwt_test.user.controller;

import com.smile.jwt_test.auth.UserDetailsImpl;
import com.smile.jwt_test.user.dto.UserCreateRequest;
import com.smile.jwt_test.user.dto.UserInfo;
import com.smile.jwt_test.user.dto.UserUpdateRequest;
import com.smile.jwt_test.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> signup(@Validated @RequestBody UserCreateRequest userCreateRequest) {

        userService.signup(userCreateRequest);
        return ResponseEntity.status(201).body("회원가입이 완료되었습니다.");

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> signin(@Validated @RequestBody UserCreateRequest userCreateRequest) {

        HttpHeaders httpHeaders = userService.signin(userCreateRequest);

        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(null);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<UserInfo> getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        return ResponseEntity.ok(userService.getUserInfo(userDetails.getUsername()));
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<UserInfo> updateUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                   @RequestBody UserUpdateRequest userUpdateRequest) {

        return ResponseEntity.ok(userService.updateUserInfo(userDetails.getUsername(), userUpdateRequest));
    }

}
