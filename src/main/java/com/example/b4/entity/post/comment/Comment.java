package com.example.b4.entity.post.comment;

import com.example.b4.entity.BaseEntity;
import com.example.b4.entity.post.Post;
import com.example.b4.entity.post.mind.Mind;
import com.example.b4.entity.user.User;
import lombok.Builder;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    private User user;

    private String commentDetail;
    private String commentAttachedFile;

    @Builder
    public Comment(Post post, User user, String commentDetail, String commentAttachedFile) {
        this.post = post;
        this.user = user;
        this.commentDetail = commentDetail;
        this.commentAttachedFile = commentAttachedFile;
    }
}
