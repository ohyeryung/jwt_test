package com.smile.jwt_test.auth;

import com.smile.jwt_test.user.domain.User;
import org.springframework.http.HttpHeaders;

public interface UserAuth {

    String getToken(User user);
    String saveRefreshTokenToRedis(User user);
    HttpHeaders generateHeaderTokens(User user);

}
