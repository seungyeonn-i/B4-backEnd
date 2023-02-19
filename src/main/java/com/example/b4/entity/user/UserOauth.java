package com.example.b4.entity.user;

import com.example.b4.entity.BaseTimeEntity;
import com.example.b4.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class UserOauth extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserOauthId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Boolean roleStatus;

}
