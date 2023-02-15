package com.example.b4.dto.play;

import lombok.Data;

@Data
public class PlayDetailDto {
    private String category;
    private String title;
    private String user;
    private String submitLink;
    private String dueTo;
    private String playDetails;
    private String playAttachedFile;

    private String playStatus;
    private String createdAt;

}
