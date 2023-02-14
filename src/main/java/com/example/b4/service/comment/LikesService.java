package com.example.b4.service.comment;


import com.example.b4.dto.comment.like.LikeDto;
import com.example.b4.dto.comment.like.LikeReq;
import com.example.b4.entity.post.Comment;
import com.example.b4.entity.post.Likes;
import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import com.example.b4.repository.comment.CommentRepository;
import com.example.b4.repository.comment.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final LikesRepository likesRepository;

    public LikeDto like(Long postId,Long commentId,LikeReq req){
        System.out.println("req.getStatus() = " + req.getStatus());
        Likes build = Likes.builder()
                .user(userRepository.findByUserId(1L))
                .comment(commentRepository.findById(commentId).get())
                .likesStatus(req.getStatus())
                .build();

        Likes save = likesRepository.save(build);
        
        return new LikeDto(commentId, save.getLikesStatus());

    }

    public Long likeNum(Long commentId) {
        Optional<Comment> optional = commentRepository.findById(commentId);
        if (optional.isPresent()) {
            Comment findComment = optional.get();
            Long num = likesRepository.countLikes(commentId, "X");
            return num;
        }else{
            return 0L;
        }
    }
}
