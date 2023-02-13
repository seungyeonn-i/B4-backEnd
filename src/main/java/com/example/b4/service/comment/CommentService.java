package com.example.b4.service.comment;


import com.example.b4.dto.comment.CommentDto;
import com.example.b4.dto.comment.CommentReq;
import com.example.b4.entity.post.Comment;
import com.example.b4.entity.post.Post;
import com.example.b4.entity.user.User;
import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import com.example.b4.repository.comment.CommentRepository;
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

    public CommentDto createComment(Long postId,CommentReq req){


        // TODO : 1번에 15개 생김
        System.out.println("postId = " + postId);
        Post findPost = postRepository.findById(postId).get();

            System.out.println("findPost = " + findPost);
            User findUser = userRepository.findById(1L).get();
        System.out.println("req.getCommentDetail() = " + req.getCommentDetail());
            Comment newComment = Comment.builder()
                    .user(findUser)
                    .post(findPost)
                    .commentDetail(req.getCommentDetail())
                    .commentAttachedFile(req.getCommentAttachedFile())
                    .build();
        Comment save = commentRepository.save(newComment);

        return new CommentDto(save.getUser().getUserNickname(),save.getCommentDetail(),save.getCommentAttachedFile(),save.getCreatedDate(),1,2);
        // TODO : 1. postId가 null 일 때
        // TODO : 2. optional 처리

    }

    public List<CommentDto> readComments(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    public Long sumComments(Long postId) {
        return commentRepository.countCommentByPostId(postId);
    }

}
