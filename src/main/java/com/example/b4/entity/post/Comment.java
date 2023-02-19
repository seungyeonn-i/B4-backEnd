package com.example.b4.entity.post;

import com.example.b4.entity.BaseEntity;
import com.example.b4.entity.User;
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
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    private User user;

    private String commentDetail;
    private String commentAttachedFile;

    public void updateCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    public void updateCommentAttachedFile(String commentAttachedFile) {
        this.commentAttachedFile = commentAttachedFile;
    }

    @Builder
    public Comment(Post post, User user, String commentDetail, String commentAttachedFile) {
        this.post = post;
        this.user = user;
        this.commentDetail = commentDetail;
        this.commentAttachedFile = commentAttachedFile;
    }
}
