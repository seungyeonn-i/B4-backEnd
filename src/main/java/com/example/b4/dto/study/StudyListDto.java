package com.example.b4.dto.study;

import lombok.Data;

@Data
public class StudyListDto {
    private String title;
    private String user;
    private String category;
    private int comments;
    private String createdAt;

    private String studyAttachedFile;

    private boolean bookmark;

}
