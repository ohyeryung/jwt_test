package com.smile.jwt_test.auth.token;

import lombok.Getter;

@Getter
public class RefreshToken {
    private final String refreshToken;
    private final String username;

    public RefreshToken(final String refreshToken, final String username) {
        this.refreshToken = refreshToken;
        this.username = username;
    }

}
