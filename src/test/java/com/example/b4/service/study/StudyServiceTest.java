package com.example.b4.service.study;

import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyDetailReq;
import com.example.b4.dto.study.StudyListDto;
import com.example.b4.entity.post.Post;
import com.example.b4.repository.study.StudyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        System.out.println("study = " + study);
        Assertions.assertThat(study.getStudyDetails()).isEqualTo("hihihihihi");
    }

    @Test
    void findAllStudy() {
        StudyDetailDto study1 = studyService.createStudy(new StudyDetailReq("국어", "hello", "hihihihihi", "heep:f;w"));
//        System.out.println("study = " + study1);
//        Assertions.assertThat(study1.getStudyDetails()).isEqualTo("hihihihihi");

        StudyDetailDto study2 = studyService.createStudy(new StudyDetailReq("수학", "hello", "hihihihihi", "heep:f;w"));
//        System.out.println("study = " + study2);
//        Assertions.assertThat(study2.getStudyDetails()).isEqualTo("please");

        List<Post> allStudy = studyService.getAllStudy();
        Assertions.assertThat(allStudy.size()).isEqualTo(2);
//
//        List<StudyListDto> studyLists = studyService.getStudyLists();
//        System.out.println("!!!!! studyLists = " + studyLists);
//        Assertions.assertThat(studyLists.size()).isEqualTo(0);

//        List<Post> study = studyService.getStudy();
//        Assertions.assertThat(study.size()).isEqualTo(2);


//        for (Post post : allStudy) {
//            System.out.println("!!!!! post = " + post.toString());
//        }
//        Assertions.assertThat(allStudy.size()).isEqualTo(2);


    }
}