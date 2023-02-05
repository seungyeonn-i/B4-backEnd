package com.example.b4.entity.post;

import com.example.b4.entity.BaseEntity;
import com.example.b4.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "study_id")
    private Study study;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    private String answerDetails;
    private String answerAttachedFiles;

    private int likes;
    private int unlikes;
}
