package com.example.b4.dto.comment;

import lombok.Data;

@Data
public class CommentReq {
    private String commentDetail;
    private String commentAttachedFile;

    public CommentReq() {
    }

    public CommentReq(String commentDetail, String commentAttachedFile) {
        this.commentDetail = commentDetail;
        this.commentAttachedFile = commentAttachedFile;
    }
}
