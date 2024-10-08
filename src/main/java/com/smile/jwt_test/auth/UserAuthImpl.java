package com.smile.jwt_test.auth;

import com.smile.jwt_test.auth.token.JwtTokenUtils;
import com.smile.jwt_test.auth.token.RefreshTokenManager;
import com.smile.jwt_test.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthImpl implements UserAuth{
    private final JwtTokenUtils jwtTokenUtils;
    private final RefreshTokenManager refreshTokenManager;

    @Override
    public String getToken(User user) {
        return jwtTokenUtils.generateJwtToken(user.getUsername());
    }

    @Override
    public String saveRefreshTokenToRedis(User user){
        return refreshTokenManager.saveRefreshToken(user.getUsername());
    }

    @Override
    public HttpHeaders generateHeaderTokens(User user) {
        HttpHeaders headers = new HttpHeaders();  // 여기서 HttpHeaders 객체를 생성
        String accessToken = getToken(user);
        String refreshToken = saveRefreshTokenToRedis(user);
        headers.set(HttpHeaders.AUTHORIZATION,"Bearer " + accessToken);
        headers.set("RefreshToken",refreshToken);
        return headers;
    }


}
