package com.example.b4.dto.mind;

import com.example.b4.dto.comment.CommentDto;
import lombok.Data;

import java.util.List;

@Data
public class MindDetailDto {
    private String category;
    private String title;
    private String user;
    private String mindDetails;
    private String createdAt;
    private String mindAttachedFile;
    private String status;

    private String password;


    private List<CommentDto> comments;

}
