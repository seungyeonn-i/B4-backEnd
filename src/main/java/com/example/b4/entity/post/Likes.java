package com.example.b4.entity.post;

import com.example.b4.entity.BaseTimeEntity;
import com.example.b4.entity.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
public class Likes extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likesId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "comment_id")
    private Comment comment;

    private String likesStatus;

    @Builder
    public Likes(User user, Comment comment, String likesStatus) {
        this.user = user;
        this.comment = comment;
        this.likesStatus = likesStatus;
    }
}
