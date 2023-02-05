package com.example.b4.entity;

import com.example.b4.entity.post.Category;
import com.example.b4.entity.post.Post;
import com.example.b4.entity.user.User;
import com.example.b4.repository.PostRepository;
import com.example.b4.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static com.example.b4.entity.user.UserRole.MENTOR;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class createEntityTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Test
    void makePost(){
        User user =  User.builder()
                .userId(1L)
                .userNickname("user1")
                .userRole(MENTOR)
                .loginId("login")
                .loginPw("pwpwpw")
                .build();
        userRepository.save(user);


        Post post = Post.builder()
                .postId(1L)
                .title("hello")
                .category(Category.국어)
                .user(user)
                .build();

        postRepository.save(post);


    }
}
