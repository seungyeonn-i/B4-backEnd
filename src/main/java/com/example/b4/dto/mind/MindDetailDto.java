package com.example.b4.dto.mind;

import com.example.b4.dto.comment.CommentDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@ToString
public class MindDetailDto {
    private String category;
    private String title;
    private String user;
    private String mindDetails;
    private String mindAttachedFile;

    private LocalDateTime createdAt;

    private boolean status;

    private String password;

    private List<CommentDto> comments;

    public MindDetailDto(String category, String title, String user, String mindDetails, String mindAttachedFile, LocalDateTime createdAt, boolean status, String password) {
        this.category = category;
        this.title = title;
        this.user = user;
        this.mindDetails = mindDetails;
        this.mindAttachedFile = mindAttachedFile;
        this.createdAt = createdAt;
        this.status = status;
        this.password = password;
    }
}
