package com.example.b4.dto.comment.like;

import lombok.Data;

@Data
public class LikeDto {
    private Long commentId;
    private String status;

    public LikeDto(Long commentId, String status) {
        this.commentId = commentId;
        this.status = status;
    }
}
