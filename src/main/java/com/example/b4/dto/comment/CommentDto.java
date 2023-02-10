package com.example.b4.dto.comment;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
public class CommentDto {
    private String user;
    private String commentDetail;
    private String commentAttachedFile;
    private LocalDateTime createdAt;

    private int like;
    private int unlike;


}
