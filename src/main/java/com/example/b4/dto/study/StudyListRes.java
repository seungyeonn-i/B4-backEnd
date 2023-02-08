package com.example.b4.dto.study;

import lombok.Data;

import java.util.List;

@Data
public class StudyListRes {
    private List<String> categories;
    private List<StudyListDto> studies;
}
