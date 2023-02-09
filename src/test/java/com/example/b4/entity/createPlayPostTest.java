package com.example.b4.entity;

import com.example.b4.repository.play.PlayRepository;
import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class createPlayPostTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PlayRepository playRepository;

    @Test
    void makePost(){
//        User user =  User.builder()
//                .userNickname("user1")
//                .userRole(MENTOR)
//                .loginId("login")
//                .loginPw("pwpwpw")
//                .build();
//        userRepository.save(user);
//
//        Post post = Post.builder()
//                .title("play1")
////                .playCategory(PlayCategory.요리)
//                .user(user)
//                .build();
//        postRepository.save(post);
////
//        Play play = Play.builder()
//                .post(post)
//                .playDetails("hihihihi")
//                .submitLink("https://localhost:8080")
//                .dueTo(Date.valueOf("2023-02-03"))
////                .playAttachedFiles("https://awiejfoaiwjef")
//                .status(PlayStatus.반려)
//                .build();
//        playRepository.save(play);


//        Post byId = postRepository.findById(1L).get();
//        Play hihihihi = playRepository.findByPlayDetails("hihihihi");
//        Assertions.assertThat(byId).isEqualTo(post);
//        Assertions.assertThat(hihihihi).isEqualTo(play);
//        Assertions.assertThat(hihihihi.getStatus()).isEqualTo(PlayStatus.반려);


    }
}
