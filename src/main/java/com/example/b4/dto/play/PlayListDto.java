package com.example.b4.dto.play;

import lombok.Data;

@Data
public class PlayListDto {
    private String title;
    private String user;
    private String category;
    private String status;
    private String createdAt;
    private String playAttachedFile;
    private boolean bookmark;
}
