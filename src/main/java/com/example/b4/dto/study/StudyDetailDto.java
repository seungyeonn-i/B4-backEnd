package com.example.b4.dto.study;

import com.example.b4.dto.comment.CommentDto;

import java.util.List;

public class StudyDetailDto {
    private String category;
    private String title;
    private String user;
    private String studyDetails;
    private String studyAttachedFile;

    private String createdAt;

    private List<CommentDto> comments;
}
