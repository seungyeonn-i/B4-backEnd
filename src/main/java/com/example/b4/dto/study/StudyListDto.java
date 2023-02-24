package com.example.b4.dto.study;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudyListDto {
    private Long studyId;
    private String user;

    private String title;
    private String category;

    private String attachedFile;
    private boolean bookmark;

    private int comments;

    private LocalDateTime createdDate;

    public StudyListDto(Long studyId, String title, String category, String attachedFile, boolean bookmark) {
        this.studyId = studyId;
        this.title = title;
        this.category = category;
        this.attachedFile = attachedFile;
        this.bookmark = bookmark;
    }

    public StudyListDto(Long studyId, String user, String title, String category, String attachedFile, boolean bookmark,LocalDateTime createdDate) {
        this.studyId = studyId;
        this.user = user;
        this.title = title;
        this.category = category;
        this.attachedFile = attachedFile;
        this.bookmark = bookmark;
        this.createdDate = createdDate;
    }

    public StudyListDto(Long studyId, String user, String title, String category, String attachedFile, boolean bookmark,LocalDateTime createdDate,int comments) {
        this.studyId = studyId;
        this.user = user;
        this.title = title;
        this.category = category;
        this.attachedFile = attachedFile;
        this.bookmark = bookmark;
        this.createdDate = createdDate;
        this.comments = comments;
    }
}
