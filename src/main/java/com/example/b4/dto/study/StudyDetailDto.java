package com.example.b4.dto.study;

import com.example.b4.dto.comment.CommentDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class StudyDetailDto {
    private String category;
    private String title;
    private String user;
    private String studyDetails;
    private String studyAttachedFile;

    private String createdAt;

    private List<CommentDto> comments;

    @Builder

    public StudyDetailDto(String category, String title, String user, String studyDetails, String studyAttachedFile) {
        this.category = category;
        this.title = title;
        this.user = user;
        this.studyDetails = studyDetails;
        this.studyAttachedFile = studyAttachedFile;
    }
}
