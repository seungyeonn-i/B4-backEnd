//package com.example.b4;
//
//import com.example.b4.dto.comment.CommentDto;
//import com.example.b4.dto.comment.CommentReq;
//import com.example.b4.dto.study.StudyDetailDto;
//import com.example.b4.dto.study.StudyDetailReq;
//import com.example.b4.entity.post.Comment;
//import com.example.b4.entity.post.Post;
//import com.example.b4.entity.post.StudyCategory;
//import com.example.b4.entity.user.User;
//import com.example.b4.entity.user.UserRole;
//import com.example.b4.repository.PostRepository;
//import com.example.b4.repository.UserRepository;
//import com.example.b4.repository.comment.CommentRepository;
//import com.example.b4.service.comment.CommentService;
//import com.example.b4.service.study.StudyService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
//@RequiredArgsConstructor
//public class TestDataInit {
//
//    private final UserRepository userRepository;
//    private final PostRepository postRepository;
//    private final CommentRepository commentRepository;
//    private final StudyService studyService;
//    private final CommentService commentService;
//
//    @PostConstruct
//    public void init() {
//        User user1 = new User("user1", UserRole.STUDENT, "user1id", "user1pw");
//        User user2 = new User("user2", UserRole.STUDENT, "user2id", "user2pw");
//        userRepository.save(user1);
//        userRepository.save(user2);
//
//        Post post1 = new Post(user1, "title1", "국어", "attachedFile", Boolean.TRUE);
//        Post post2 = new Post(user2, "title2", "수학", "attachedFile2", Boolean.TRUE);
//
//        postRepository.save(post1);
//        postRepository.save(post2);
//
//        Comment comment1 = new Comment(post1, user2, "commentdetails1", "attachedFile1");
//        Comment comment2 = new Comment(post1, user2, "commentdetails2", "attachedFile2");
//        commentRepository.save(comment1);
//        commentRepository.save(comment2);
//
//    }
//}
