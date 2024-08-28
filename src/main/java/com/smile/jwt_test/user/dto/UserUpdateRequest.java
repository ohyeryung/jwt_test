package com.smile.jwt_test.user.dto;

import com.smile.jwt_test.user.domain.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateRequest {

    @NotNull(message = "경도 값은 필수 입력값입니다.")
    private Double x;
    @NotNull(message = "위도 값은 필수 입력값입니다.")
    private Double y;
    private boolean wantLunchRecommend;

    public User toUpdateEntity(User user) {

        return User.builder()
                .username(user.getUsername())
                .x(this.getX())
                .y(this.getY())
                .wantLunchRecommend(this.isWantLunchRecommend())
                .build();
    }

}
