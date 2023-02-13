package com.example.b4.controller;

import com.example.b4.dto.comment.CommentReq;
import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyDetailReq;
import com.example.b4.dto.study.StudyListDto;
import com.example.b4.dto.study.StudyListRes;
import com.example.b4.service.study.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studys")
public class StudyController {

    private final StudyService studyService;

    @GetMapping
    public ResponseEntity<StudyListRes> getStudyList() {

        StudyListRes studyListRes = new StudyListRes();
        studyListRes.setStudies(studyService.getStudyLists());
//        studyListRes.setCategories("");
        return new ResponseEntity<>(studyListRes,HttpStatus.ACCEPTED);
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<StudyListRes> getStudyListByCategory(@PathVariable String category) {
        StudyListRes studyListRes = new StudyListRes();

        List newCategory = new ArrayList();
        newCategory.add(category);
        studyListRes.setCategories(newCategory);
        studyListRes.setStudies(studyService.getStudyListsByCategory(category));

        return new ResponseEntity<>(studyListRes, HttpStatus.ACCEPTED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyDetailDto> getStudyDetail(@PathVariable Long id) {
        return new ResponseEntity<>(studyService.getStudyDetailByPostId(id).get(0),HttpStatus.ACCEPTED);
    }

    //    @PostMapping("/{id}")
//    public ResponseEntity<StudyDetailDto> postStudyDetail(@PathVariable Long id, StudyDetailReq studyDetailReq) {
//        return new ResponseEntity<>(studyService.createStudy(studyDetailReq),HttpStatus.ACCEPTED);
//    }
    @ResponseBody
    @PostMapping("/new")
    public ResponseEntity<StudyDetailDto> postStudyDetail(@RequestBody StudyDetailReq studyDetailReq) {
        StudyDetailDto study = studyService.createStudy(studyDetailReq);
        System.out.println("study = " + study);
        return new ResponseEntity<>(studyService.createStudy(studyDetailReq), HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public void putStudyDetail(@PathVariable Long id) {

    }
    @DeleteMapping("/{id}")
    public void deleteStudyDetail(@PathVariable Long id) {

    }

    @PostMapping("/{id}/comment")
    public void postComment(@PathVariable("id")Long id, CommentReq commentReq) {

    }
    @PutMapping("/{id}/comment")
    public void putComment(@PathVariable("id")Long id, CommentReq commentReq) {

    }
    @DeleteMapping("/{id}/comment")
    public void deleteComment(@PathVariable("id")Long id, CommentReq commentReq) {

    }

    @PostMapping("/{id}/comment/{comment-id}/like")
    public void postLike(@PathVariable("id") Long id, @PathVariable("comment-id") Long commentId) {

    }
    @PostMapping("/{id}/comment/{comment-id}/unlike")
    public void postUnlike(@PathVariable("id") Long id, @PathVariable("comment-id") Long commentId) {

    }
    @PostMapping("/{id}/comment/{comment-id}/cancel")
    public void deleteLike(@PathVariable("id") Long id, @PathVariable("comment-id") Long commentId) {

    }



}
