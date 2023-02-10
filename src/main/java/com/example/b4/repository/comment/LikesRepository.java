package com.example.b4.repository.comment;

import com.example.b4.entity.post.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes,Long> {
}
