package com.smile.jwt_test.auth.token;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;

@Component
@RequiredArgsConstructor
@Slf4j
public class RefreshTokenManager {
    private final static int TOKEN_LENGTH = 32;
    private final SecureRandom secureRandom;
    private final RefreshTokenRepository refreshTokenRepository;

    public String refreshTokenGenerator(){

        byte[] randomBytes = new byte[TOKEN_LENGTH];
        secureRandom.nextBytes(randomBytes);
        // 생성된 난수를 Base64로 인코딩하여 Refresh Token 생성
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public String saveRefreshToken(final String userEmail){
        String refreshToken = refreshTokenGenerator();
        log.info("generated RefreshToken = {} ", refreshToken);
        if(refreshTokenRepository.findByEmail(refreshToken).isPresent()){
            saveRefreshToken(userEmail);
        }else{
            refreshTokenRepository.save(new RefreshToken(refreshToken,userEmail));
        }
        return refreshToken;
    }

}
