package com.example.b4.dto.mind;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MindListDto {
    private Long postId;
    private String user;

    private String title;
    private String category;
    private String mindAttachedFile;
    private boolean bookmark;
    private boolean status; // 공개 여부

    private int comments;

    private LocalDateTime createdDate;

}
