package com.example.b4.entity.post;

import com.example.b4.entity.BaseEntity;
import com.example.b4.entity.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "advice_id")
    private Advice advice;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    private String adviceDetails;

}
