package com.example.b4.repository;

import com.example.b4.entity.post.play.Play;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayRepository extends JpaRepository<Play,Long> {
    Play findByPlayDetails(String playDetails);
}
