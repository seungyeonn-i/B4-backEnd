package com.example.b4.entity.post.comment;

import com.example.b4.entity.BaseEntity;
import com.example.b4.entity.post.mind.Mind;
import com.example.b4.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Mind mind;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    private String commentDetail;

}
