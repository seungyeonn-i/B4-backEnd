package com.example.b4.dto.study;

import com.example.b4.dto.comment.CommentDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
@ToString
public class StudyDetailDto {
    private String category;
    private String title;
    private String user;
    private String studyDetails;
    private String studyAttachedFile;

    private LocalDateTime createdAt;

    private List<CommentDto> comments;

    public StudyDetailDto(String category, String title, String user, String studyDetails, String studyAttachedFile, LocalDateTime createdAt) {
        this.category = category;
        this.title = title;
        this.user = user;
        this.studyDetails = studyDetails;
        this.studyAttachedFile = studyAttachedFile;
        this.createdAt = createdAt;
    }

    @Builder
    public StudyDetailDto(String category, String title, String user, String studyDetails, String studyAttachedFile) {
        this.category = category;
        this.title = title;
        this.user = user;
        this.studyDetails = studyDetails;
        this.studyAttachedFile = studyAttachedFile;
    }
}
