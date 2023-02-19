package com.example.b4.entity.user;

import com.example.b4.entity.BaseTimeEntity;
import com.example.b4.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class UserInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInfoId;

    @OneToOne
    @JoinColumn(name = "user_Id")
    private User user;

    private String userName;
    private String userPhone;
    private Date userBirth;
    private String userJob;
    private String userEmail;


}
