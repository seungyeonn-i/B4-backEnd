package com.example.b4.service.comment;


import com.example.b4.dto.comment.like.LikeDto;
import com.example.b4.dto.comment.like.LikeReq;
import com.example.b4.entity.User;
import com.example.b4.entity.post.Comment;
import com.example.b4.entity.post.Likes;
import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import com.example.b4.repository.comment.CommentRepository;
import com.example.b4.repository.comment.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional

@Service
@RequiredArgsConstructor
public class LikesService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final LikesRepository likesRepository;

    public LikeDto like(Long postId,Long commentId,LikeReq req,Long userId){
        System.out.println("req.getStatus() = " + req.getStatus());
        if(req.getStatus().equals("N")){
            likesRepository.deleteLikesByUser(userId);
            return new LikeDto(commentId, "N");

        } else {
            Comment findComment = commentRepository.findById(commentId).get();
            User findUser = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalStateException("회원 없음"));;
            Optional<Likes> optional = likesRepository.findLikesByCommentAndUser(findComment, findUser);
            if (optional.isPresent()) {
                Likes findLikes = optional.get();
                findLikes.setLikesStatus(req.getStatus());
                Likes save = likesRepository.save(findLikes);
                return new LikeDto(commentId, save.getLikesStatus());
            }else {
                Likes build = Likes.builder()
                        .user(userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("회원 없음")))
                        .comment(commentRepository.findById(commentId).get())
                        .likesStatus(req.getStatus())
                        .build();

                Likes save = likesRepository.save(build);

                return new LikeDto(commentId, save.getLikesStatus());
            }
        }

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
