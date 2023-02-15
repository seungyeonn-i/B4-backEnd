package com.example.b4.dto.comment;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
public class CommentDto {
    private Long commentId;
    private String user;
    private String commentDetail;
    private String commentAttachedFile;
    private LocalDateTime createdAt;

    private Long like;
    private Long unlike;

    public CommentDto(Long commentId, String user, String commentDetail, String commentAttachedFile, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.user = user;
        this.commentDetail = commentDetail;
        this.commentAttachedFile = commentAttachedFile;
        this.createdAt = createdAt;
    }
}
