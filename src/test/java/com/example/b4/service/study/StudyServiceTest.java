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
        StudyDetailDto study1 = studyService.createStudy(new StudyDetailReq("korean", "hello", "hihihihihi", "heep:f;w"));

        StudyDetailDto study2 = studyService.createStudy(new StudyDetailReq("math", "hello", "hihihihihi", "heep:f;w"));
//        System.out.println("study = " + study2);
//        Assertions.assertThat(study2.getStudyDetails()).isEqualTo("please");

        // TODO : return post list
        List<Post> allStudy = studyService.getAllStudy();
        for (Post post : allStudy) {
            System.out.println("!!!!!"+allStudy.size());
        }
        Assertions.assertThat(allStudy.size()).isEqualTo(2);

        // TODO : return studyListDto
        List<StudyListDto> studyLists = studyService.getStudyLists();
        for (StudyListDto studyList : studyLists) {
            System.out.println("!!!!!studyList = " + studyList.toString());
        }
        Assertions.assertThat(studyLists.size()).isEqualTo(2);

        // TODO : return StudyDetailDto
//        List<StudyDetailDto> studyDetail = studyService.getStudyDetail();
//        for (StudyDetailDto studyDetailDto : studyDetail) {
//            System.out.println("!!!! studyDetailDto.toString() = " + studyDetailDto.toString());
//        }
//        Assertions.assertThat(studyLists.size()).isEqualTo(2);

        // TODO : return ByCategoryStudyListDto (o)
        List<StudyListDto> studyByCategoryLists = studyService.getStudyListsByCategory("korean");
        for (StudyListDto studyByCategoryList : studyByCategoryLists) {
            System.out.println("!!!! studyByCategoryLists.toString() = " + studyByCategoryList.toString());
        }
        Assertions.assertThat(studyByCategoryLists.size()).isEqualTo(1); // 1

        // TODO : return StudyDetailDto By PostId
//        List<StudyDetailDto> studyDetail2 = studyService.getStudyDetailByPostId(1L);
//        for (StudyDetailDto studyDetailDto : studyDetail2) {
//            System.out.println("????? studyDetailDto.toString() = " + studyDetailDto.toString());
//        }
    }


}