package com.example.b4.dto.study;

import lombok.Data;

@Data
public class StudyDetailReq {
    private String category;
    private String title;
    private String studyDetails;
    private String studyAttachedFile;
}
