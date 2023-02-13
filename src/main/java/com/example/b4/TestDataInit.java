package com.example.b4;

import com.example.b4.entity.user.User;
import com.example.b4.entity.user.UserRole;
import com.example.b4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user1 = new User("user1", UserRole.STUDENT, "user1id", "user1pw");
        User user2 = new User("user2", UserRole.STUDENT, "user2id", "user2pw");
        userRepository.save(user1);
        userRepository.save(user2);
    }
}
