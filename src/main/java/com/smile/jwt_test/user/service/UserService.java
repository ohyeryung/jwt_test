package com.smile.jwt_test.user.service;

import com.smile.jwt_test.user.dto.UserCreateRequest;
import com.smile.jwt_test.user.dto.UserInfo;
import com.smile.jwt_test.user.dto.UserUpdateRequest;
import org.springframework.http.HttpHeaders;

public interface UserService {

    void signup(UserCreateRequest userCreateRequest);

    HttpHeaders signin(UserCreateRequest userCreateRequest);

    UserInfo getUserInfo(String username);

    UserInfo updateUserInfo(String username, UserUpdateRequest userUpdateRequest);

}
