package com.example.b4.dto.play;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
public class PlayDetailDto {
    private String category;
    private String title;
    private String user;
    private String playDetails;
    private String playAttachedFile;

    private LocalDateTime createdAt;

    private String submitLink;
    private LocalDateTime dueTo;
    private String playStatus;

}
