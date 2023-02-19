package com.example.b4.dto.play;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayListDto {
    private Long playId;
    private String user;

    private String title;
    private String category;
    private String attachedFile;
    private boolean bookmark;

    private LocalDateTime createdDate;
    private String status;


}
