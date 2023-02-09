package com.example.b4.entity.user;

import com.example.b4.entity.BaseTimeEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
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
}
