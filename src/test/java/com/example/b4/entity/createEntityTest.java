package com.example.b4.entity;

import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class createEntityTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

//    @Test
//    void makePost(){
//        User user =  User.builder()
//                .userId(1L)
//                .userNickname("user1")
//                .userRole(MENTOR)
//                .loginId("login")
//                .loginPw("pwpwpw")
//                .build();
//        userRepository.save(user);
//
//
//        Post post = Post.builder()
////                .postId(1L)
//                .title("hello")
////                .playCategory(PlayCategory.요리)
//                .user(user)
//                .build();
//
//        postRepository.save(post);


//    }
}
