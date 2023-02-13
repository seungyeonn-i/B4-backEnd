package com.example.b4.entity.user;

import com.example.b4.entity.BaseTimeEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = PROTECTED)
@EqualsAndHashCode(callSuper=false)
@Table(name="Member")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userNickname;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String loginId;
    private String loginPw;

    public User(String userNickname, UserRole userRole, String loginId, String loginPw) {
        this.userNickname = userNickname;
        this.userRole = userRole;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }
}
