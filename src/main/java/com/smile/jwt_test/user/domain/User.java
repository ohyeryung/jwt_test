package com.smile.jwt_test.user.domain;

import com.smile.jwt_test.user.dto.UserInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_USER")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Double x;

    @Column(nullable = false)
    private Double y;

    @Column
    private boolean wantLunchRecommend;

    public UserInfo fromEntity(String username) {

        return UserInfo.builder()
                .username(username)
                .x(x)
                .y(y)
                .wantLunchRecommend(wantLunchRecommend)
                .build();
    }

    public void update(User initUser) {

        this.username = initUser.getUsername();
        this.x = initUser.getX();
        this.y = initUser.getY();
        this.wantLunchRecommend = initUser.wantLunchRecommend;
    }


}
