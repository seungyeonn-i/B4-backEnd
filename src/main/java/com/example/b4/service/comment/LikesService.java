package com.example.b4.service.comment;


import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import com.example.b4.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
}
