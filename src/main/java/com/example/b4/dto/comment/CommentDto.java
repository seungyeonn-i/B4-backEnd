package com.example.b4.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CommentDto {
    private String user;
    private String commentDetail;
    private String commentAttachedFile;
    private String createdAt;

    private int like;
    private int unlike;

}
