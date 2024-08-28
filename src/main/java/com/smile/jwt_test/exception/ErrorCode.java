package com.smile.jwt_test.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // USER
    USER_NOT_EXIST(HttpStatus.NOT_FOUND, "가입되지 않은 아이디입니다."),
    USERNAME_DUPLICATION(HttpStatus.BAD_REQUEST, "중복된 계정명입니다."),
    PASSWORD_NOT_VALID(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    INVALID_USERNAME_LENGTH(HttpStatus.BAD_REQUEST, "계정명은 3자 이상 20자 이하로 설정해야 합니다.");

    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message) {

        this.httpStatus = httpStatus;
        this.message = message;
    }
}
