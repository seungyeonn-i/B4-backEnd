package com.example.b4.dto.study;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudyDetailReq {
    private String category;
    private String title;
    private String studyDetails;
    private String studyAttachedFile;


    public StudyDetailReq(String category, String title, String studyDetails, String studyAttachedFile) {
        this.category = category;
        this.title = title;
        this.studyDetails = studyDetails;
        this.studyAttachedFile = studyAttachedFile;
    }
}
