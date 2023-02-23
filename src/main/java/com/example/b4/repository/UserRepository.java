package com.example.b4.repository;

import com.example.b4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long userId);
    User findByUsername(String username);
    Optional<User> findByLoginId(String loginId);
    Optional<User> findByEmail(String email);
}
