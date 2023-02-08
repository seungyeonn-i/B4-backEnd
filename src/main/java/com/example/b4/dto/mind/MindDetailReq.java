package com.example.b4.dto.mind;

import lombok.Data;

@Data
public class MindDetailReq {
    private String category;
    private String title;
    private String mindDetails;
    private String mindAttachedFile;
    private String status;

    private String password;
}
