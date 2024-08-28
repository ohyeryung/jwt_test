package com.smile.jwt_test.user.dto;

import com.smile.jwt_test.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private String username;
    private Double x;
    private Double y;
    private boolean wantLunchRecommend;

    public UserInfo(User user) {

        this.username = user.getUsername();
        this.x = user.getX();
        this.y = user.getY();
        this.wantLunchRecommend = user.isWantLunchRecommend();
    }

}
