package com.example.b4.service.comment;

import com.example.b4.dto.comment.CommentDto;
import com.example.b4.dto.comment.CommentReq;
import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyDetailReq;
import com.example.b4.entity.post.Study;
import com.example.b4.service.study.StudyService;
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
class CommentServiceTest {

    @Autowired
    CommentService commentService;
    @Autowired
    StudyService studyService;

    @Test
    void createComment() {

        StudyDetailDto study1 = studyService.createStudy(new StudyDetailReq("korean", "hello", "hihihihihi", "heep:f;w"));

        CommentDto comment = commentService.createComment(1L, new CommentReq("hihihihihi", "lijlji"));
        System.out.println("comment = " + comment);

    }

}