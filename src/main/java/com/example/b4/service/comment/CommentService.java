package com.example.b4.service.comment;


import com.example.b4.dto.comment.CommentDto;
import com.example.b4.dto.comment.CommentReq;
import com.example.b4.entity.post.Comment;
import com.example.b4.entity.post.Post;
import com.example.b4.entity.user.User;
import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import com.example.b4.repository.comment.CommentRepository;
import com.example.b4.repository.comment.LikesRepository;
import com.example.b4.repository.study.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final LikesRepository likesRepository;
    private final StudyRepository studyRepository;

    public CommentDto createComment(Long studyId,CommentReq req){

        Post findPost = studyRepository.findPostByStudy(studyId);

//        Post findPost = postRepository.findById(postId).get();

        User findUser = userRepository.findById(1L).get();
        Comment newComment = Comment.builder()
                .user(findUser)
                .post(findPost)
                .commentDetail(req.getCommentDetail())
                .commentAttachedFile(req.getCommentAttachedFile())
                .build();
        Comment save = commentRepository.save(newComment);

        return new CommentDto(save.getCommentId(),save.getUser().getUserNickname(),save.getCommentDetail(),save.getCommentAttachedFile(),save.getCreatedDate());
        // TODO : 1. postId가 null 일 때
        // TODO : 2. optional 처리

    }

    public List<CommentDto> readComments(Long studyId) {

        Post findPost = studyRepository.findPostByStudy(studyId);
        Long postId = findPost.getPostId();

        List<CommentDto> allByPostId = commentRepository.findAllByPostId(postId);
        for (CommentDto commentDto : allByPostId) {
            commentDto.setLike(likesRepository.countLikes(commentDto.getCommentId(),"O"));
            commentDto.setUnlike(likesRepository.countLikes(commentDto.getCommentId(),"X"));
        }
        return allByPostId;
    }

    public CommentDto updateComment(Long postId, Long commentId, CommentReq commentReq) {
        Comment updateComment = commentRepository.findById(commentId).get();

        updateComment.updateCommentDetail(commentReq.getCommentDetail());
        updateComment.updateCommentAttachedFile(commentReq.getCommentAttachedFile());
        Comment savedComment = commentRepository.save(updateComment);
        return new CommentDto(savedComment.getCommentId(), savedComment.getUser().getUserNickname(), savedComment.getCommentDetail(), savedComment.getCommentAttachedFile(), savedComment.getCreatedDate());
    }

    public void deleteComment(Long commentId) {
        Comment deleteComment = commentRepository.findById(commentId).get();
        commentRepository.delete(deleteComment);
    }

    public Long sumComments(Long postId) {
        return commentRepository.countCommentByPostId(postId);
    }


}
