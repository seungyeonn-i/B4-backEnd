package com.example.b4.service.comment;


import com.example.b4.dto.comment.like.LikeDto;
import com.example.b4.dto.comment.like.LikeReq;
import com.example.b4.entity.post.Likes;
import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import com.example.b4.repository.comment.CommentRepository;
import com.example.b4.repository.comment.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
