package com.example.b4.dto.mind;

import lombok.Data;

@Data
public class MindListDto {
    private String title;
    private String user;
    private String category;
    private int comments;
    private String status; // 공개 여부
    private String createdAt;

    private String mindAttachedFile;

    private boolean bookmark;
}
