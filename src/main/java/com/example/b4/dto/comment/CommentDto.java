package com.example.b4.dto.comment;

import lombok.Data;

@Data
public class CommentDto {
    private String user;
    private String commentDetail;
    private String commentAttachedFile;
    private String createdAt;

    private int like;
    private int unlike;

}
