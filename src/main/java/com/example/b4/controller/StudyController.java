package com.example.b4.controller;

import com.example.b4.dto.comment.CommentDto;
import com.example.b4.dto.comment.CommentReq;
import com.example.b4.dto.comment.like.LikeDto;
import com.example.b4.dto.comment.like.LikeReq;
import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyDetailReq;
import com.example.b4.dto.study.StudyListDto;
import com.example.b4.dto.study.StudyListRes;
import com.example.b4.entity.post.StudyCategory;
import com.example.b4.service.comment.CommentService;
import com.example.b4.service.comment.LikesService;
import com.example.b4.service.study.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studys")
public class StudyController {

    private final StudyService studyService;
    private final CommentService commentService;
    private final LikesService likesService;

    @GetMapping
    public ResponseEntity<StudyListRes> getStudyList() {

        StudyListRes studyListRes = new StudyListRes();
        studyListRes.setStudies(studyService.getStudyLists());


        // TODO : Study-Category to List -> clear
        // TODO : Study Count(comments) -> clear

        // Enum to List
        List<String> newString = Stream.of(StudyCategory.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        studyListRes.setCategories(newString);

        Long aLong = commentService.sumComments(3L);
        System.out.println("aLong = " + aLong);
        return new ResponseEntity<>(studyListRes,HttpStatus.ACCEPTED);
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<StudyListRes> getStudyListByCategory(@PathVariable("category") String category) {
        StudyListRes studyListRes = new StudyListRes();

        List newCategory = new ArrayList();
        newCategory.add(category);
        studyListRes.setCategories(newCategory);
        studyListRes.setStudies(studyService.getStudyListsByCategory(category));

        return new ResponseEntity<>(studyListRes, HttpStatus.ACCEPTED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyDetailDto> getStudyDetail(@PathVariable Long id) {
        return new ResponseEntity<>(studyService.getStudyDetailByPostId(id),HttpStatus.ACCEPTED);
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

    @ResponseBody
    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentDto> postComment( @PathVariable("id")Long id, @RequestBody CommentReq commentReq) {
        System.out.println("!!!! commentReq.getCommentDetail() = " + commentReq.getCommentDetail());
        return new ResponseEntity<>(commentService.createComment(id, commentReq),HttpStatus.ACCEPTED);

    }
    @PutMapping("/{id}/comment")
    public void putComment(@PathVariable("id")Long id, CommentReq commentReq) {

    }
    @DeleteMapping("/{id}/comment")
    public void deleteComment(@PathVariable("id")Long id, CommentReq commentReq) {

    }
    // TODO : postId,userId,commentId 구분. postId 필요 없지 않나
    Long userId = 1L;
    @ResponseBody
    @PostMapping("/{id}/comment/{comment-id}/like")
    public ResponseEntity<LikeDto> postLike(@PathVariable("id") Long id, @PathVariable("comment-id")  Long commentId, @RequestBody LikeReq req) {
        System.out.println("req = " + req.getStatus());
        return new ResponseEntity<>(likesService.like(id, commentId, req,userId), HttpStatus.ACCEPTED);
    }
    @ResponseBody
    @PostMapping("/{id}/comment/{comment-id}/unlike")
    public ResponseEntity<LikeDto> postUnlike(@PathVariable("id") Long id, @PathVariable("comment-id") Long commentId ,@RequestBody LikeReq req) {
        return new ResponseEntity<>(likesService.like(id, commentId, req,userId), HttpStatus.ACCEPTED);
    }
    @ResponseBody
    @PostMapping("/{id}/comment/{comment-id}/cancel")
    public ResponseEntity<LikeDto> deleteLike(@PathVariable("id") Long id, @PathVariable("comment-id") Long commentId,@RequestBody LikeReq req) {
        return new ResponseEntity<>(likesService.like(id, commentId, req,userId), HttpStatus.ACCEPTED);

    }

    @ResponseBody
    @GetMapping("/comment/{comment-id}")
    public ResponseEntity<Long> test(@PathVariable("comment-id") Long commentId) {
        Long aLong = likesService.likeNum(commentId);
        return new ResponseEntity<>(aLong, HttpStatus.ACCEPTED);
    }



}
