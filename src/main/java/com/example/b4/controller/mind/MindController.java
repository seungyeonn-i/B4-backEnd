package com.example.b4.controller.mind;

import com.example.b4.dto.BookmarkDto;
import com.example.b4.dto.comment.CommentDto;
import com.example.b4.dto.comment.CommentReq;
import com.example.b4.dto.comment.like.LikeDto;
import com.example.b4.dto.comment.like.LikeReq;
import com.example.b4.dto.mind.MindDetailDto;
import com.example.b4.dto.mind.MindDetailReq;
import com.example.b4.dto.mind.MindListRes;

import com.example.b4.entity.post.MindCategory;
import com.example.b4.repository.mind.MindRepository;
import com.example.b4.service.comment.CommentService;
import com.example.b4.service.comment.LikesService;
import com.example.b4.service.mind.MindService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/minds")
public class MindController {

    private final MindService mindService;
    private final CommentService commentService;
    private final LikesService likesService;

    /**
     * 꼭 수정
     */
    private final Long userId = 1l;

    @GetMapping
    public ResponseEntity<MindListRes> getMindList() {

        MindListRes mindListRes = new MindListRes();

        mindListRes.setMinds(mindService.getMindLists());

        List<String> newString = Stream.of(MindCategory.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        mindListRes.setCategories(newString);

        return new ResponseEntity<>(mindListRes, HttpStatus.OK);
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<MindListRes> getMindListByCategory(@PathVariable("category") String category) {

        MindListRes mindListRes = new MindListRes();

        mindListRes.setMinds(mindService.getMindLists());

        List newCategory = new ArrayList();
        newCategory.add(category);
        mindListRes.setCategories(newCategory);

        return new ResponseEntity<>(mindListRes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MindDetailDto> getStudyDetail(@PathVariable("id") Long mindId) {
        return new ResponseEntity<>(mindService.getMindDetailsByMindId(mindId), HttpStatus.OK);
    }

    @ResponseBody @PostMapping("/new")
    public ResponseEntity<MindDetailDto> postMindDetail(@RequestBody MindDetailReq mindDetailReq) {
        return new ResponseEntity<>(mindService.createMind(mindDetailReq, userId), HttpStatus.OK);
    }

    @ResponseBody @PutMapping("/{id}")
    public ResponseEntity<MindDetailDto> putMindDetail(@PathVariable("id") Long mindId, @RequestBody MindDetailReq mindDetailReq) {
        return new ResponseEntity<>(mindService.updateMind(mindId, mindDetailReq, userId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMindDetail(@PathVariable("id") Long mindId) {
        mindService.deleteMind(mindId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     * comment
     **/


    @ResponseBody
    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentDto> postComment(@PathVariable("id") Long mindId, @RequestBody CommentReq commentReq) {
        Long postId = mindRepository.findPostByMind(mindId).getPostId();
        return new ResponseEntity<>(commentService.createComment(postId, commentReq, userId), HttpStatus.OK);

    }
    @ResponseBody @PutMapping("/{id}/comment/{comment-id}")
    public ResponseEntity<CommentDto> putComment(@PathVariable("id")Long mindId, @PathVariable("comment-id") Long commentId,@RequestBody CommentReq commentReq) {
        return new ResponseEntity<>(commentService.updateComment(mindId, commentId, commentReq),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}/comment/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("id") Long mindId,@PathVariable("comment-id")Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    private final MindRepository mindRepository;

    /**
     * Like
     */

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
        return new ResponseEntity<>(likesService.like(id, commentId, req,userId), HttpStatus.NO_CONTENT);
    }

    @ResponseBody
    @PostMapping("{id}/bookmark")
    public ResponseEntity<String> postBookmark(@PathVariable("id") Long mindId, @RequestBody BookmarkDto bookmark) {
        return new ResponseEntity<>(mindService.bookmark(mindId, bookmark.getBookmark()), HttpStatus.OK);
    }
}
