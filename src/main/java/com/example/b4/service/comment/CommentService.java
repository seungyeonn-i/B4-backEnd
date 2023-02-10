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


        Optional<Post> optional = postRepository.findById(postId);
        Post findPost = null;
        if(optional.isPresent()){
            findPost =  optional.get();

            System.out.println("findPost = " + findPost);
    //        Optional<User> findUser = userRepository.findById(1L);
    //        UserRepository.findById(req.user)
            Comment newComment = Comment.builder()
                    .user(null)
                    .post(findPost)
                    .commentDetail(req.getCommentDetail())
                    .commentAttachedFile(req.getCommentAttachedFile())
                    .build();
            Comment save = commentRepository.save(newComment);
            return new CommentDto("user1",save.getCommentDetail(),save.getCommentAttachedFile(), LocalDateTime.now(),1,2);

        } else{
            // TODO : postId가 null 일 때
//            throw new Exception();
        }
        return null;

    }

    public List<CommentDto> readComments(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }
}
