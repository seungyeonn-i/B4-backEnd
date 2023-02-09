package com.example.b4.service.study;

import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyDetailReq;
import com.example.b4.repository.study.StudyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@Rollback(value = false)
@SpringBootTest
public class StudyServiceTest {

    @Autowired
    StudyService studyService;
    @Autowired
    StudyRepository studyRepository;

    @Test
    void createStudy() {

        StudyDetailDto study = studyService.createStudy(new StudyDetailReq("국어", "hello", "hihihihihi", "heep:f;w"));

        Assertions.assertThat(study.getStudyDetails()).isEqualTo("hihihihihi");
    }
}