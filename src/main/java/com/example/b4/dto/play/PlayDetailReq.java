package com.example.b4.dto.play;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlayDetailReq {
    private String category;
    private String title;
    private String submitLink;
    private String dueTo;
    private String playDetails;
    private String playAttachedFile;

}
