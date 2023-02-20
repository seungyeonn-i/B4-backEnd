package com.example.b4.controller.study;

import com.example.b4.dto.BookmarkDto;
import com.example.b4.dto.comment.CommentDto;
import com.example.b4.dto.comment.CommentReq;
import com.example.b4.dto.comment.like.LikeDto;
import com.example.b4.dto.comment.like.LikeReq;
import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyDetailReq;
import com.example.b4.dto.study.StudyListDto;
import com.example.b4.dto.study.StudyListRes;
import com.example.b4.entity.post.StudyCategory;
import com.example.b4.repository.study.StudyRepository;
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

    /**
     * 꼭 수정
     */
    private final Long userId = 1l;

    @GetMapping
    public ResponseEntity<StudyListRes> getStudyList() {

        StudyListRes studyListRes = new StudyListRes();
        studyListRes.setStudies(studyService.getStudyLists());

        List<String> newString = Stream.of(StudyCategory.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        studyListRes.setCategories(newString);

        return new ResponseEntity<>(studyListRes,HttpStatus.OK);
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<StudyListRes> getStudyListByCategory(@PathVariable("category") String category) {
        StudyListRes studyListRes = new StudyListRes();

        List newCategory = new ArrayList();
        newCategory.add(category);
        studyListRes.setCategories(newCategory);
        studyListRes.setStudies(studyService.getStudyListsByCategory(category));

        return new ResponseEntity<>(studyListRes, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyDetailDto> getStudyDetail(@PathVariable("id") Long studyId) {
        return new ResponseEntity<>(studyService.getStudyDetailByStudyId(studyId),HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/new")
    public ResponseEntity<StudyDetailDto> postStudyDetail(@RequestBody StudyDetailReq studyDetailReq) {
        return new ResponseEntity<>(studyService.createStudy(studyDetailReq, userId), HttpStatus.OK);
    }
    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<StudyDetailDto> putStudyDetail(@PathVariable("id") Long studyId, @RequestBody StudyDetailReq studyDetailReq) {
        return new ResponseEntity<>(studyService.updateStudy(studyId, studyDetailReq, userId), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudyDetail(@PathVariable("id") Long studyId) {
        studyService.deleteStudy(studyId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * Comment
     **/

    @ResponseBody
    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentDto> postComment(@PathVariable("id") Long studyId, @RequestBody CommentReq commentReq) {
        Long postId = studyRepository.findPostByStudy(studyId).getPostId();
        return new ResponseEntity<>(commentService.createComment(postId, commentReq,userId), HttpStatus.OK);

    }
    @ResponseBody
    @PutMapping("/{id}/comment/{comment-id}")
    public ResponseEntity<CommentDto> putComment(@PathVariable("id")Long studyId, @PathVariable("comment-id") Long commentId,@RequestBody CommentReq commentReq) {
        return new ResponseEntity<>(commentService.updateComment(studyId, commentId, commentReq),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}/comment/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("id") Long id,@PathVariable("comment-id")Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    /**
        Like
     **/
    private final StudyRepository studyRepository;

    @ResponseBody
    @PostMapping("/{id}/comment/{comment-id}/like")
    public ResponseEntity<LikeDto> postLike(@PathVariable("id") Long postId, @PathVariable("comment-id")  Long commentId, @RequestBody LikeReq req) {
        return new ResponseEntity<>(likesService.like(postId, commentId, req,userId), HttpStatus.OK);
    }
    @ResponseBody
    @PostMapping("/{id}/comment/{comment-id}/unlike")
    public ResponseEntity<LikeDto> postUnlike(@PathVariable("id") Long id, @PathVariable("comment-id") Long commentId ,@RequestBody LikeReq req) {
        return new ResponseEntity<>(likesService.like(id, commentId, req,userId), HttpStatus.OK);
    }
    @ResponseBody
    @PostMapping("/{id}/comment/{comment-id}/cancel")
    public ResponseEntity<LikeDto> deleteLike(@PathVariable("id") Long id, @PathVariable("comment-id") Long commentId,@RequestBody LikeReq req) {
        return new ResponseEntity<>(likesService.like(id, commentId, req,userId), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("{id}/bookmark")
    public ResponseEntity<String> postBookmark(@PathVariable("id") Long studyId, @RequestBody BookmarkDto bookmark) {
        return new ResponseEntity<>(studyService.bookmark(studyId, bookmark.getBookmark()), HttpStatus.OK);
    }


}
