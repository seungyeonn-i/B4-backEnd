package com.example.b4.dto.study;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudyListDto {
    private Long postId;
    private String user;

    private String title;
    private String category;
    private String attachedFile;
    private boolean bookmark;

    private Long comments;

    private LocalDateTime createdDate;

    public StudyListDto(Long postId, String title, String category, String attachedFile, boolean bookmark) {
        this.postId = postId;
        this.title = title;
        this.category = category;
        this.attachedFile = attachedFile;
        this.bookmark = bookmark;
    }

    public StudyListDto(Long postId, String user, String title, String category, String attachedFile, boolean bookmark) {
        this.postId = postId;
        this.user = user;
        this.title = title;
        this.category = category;
        this.attachedFile = attachedFile;
        this.bookmark = bookmark;
    }

    public StudyListDto(Long postId, String user, String title, String category, String attachedFile, boolean bookmark, Long comments) {
        this.postId = postId;
        this.user = user;
        this.title = title;
        this.category = category;
        this.attachedFile = attachedFile;
        this.bookmark = bookmark;
        this.comments = comments;
    }
}
