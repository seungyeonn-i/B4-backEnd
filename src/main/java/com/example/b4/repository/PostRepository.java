package com.example.b4.repository;

import com.example.b4.dto.study.StudyListDto;
import com.example.b4.entity.post.Post;
import com.example.b4.entity.post.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select new com.example.b4.dto.study.StudyListDto(" +
            "p.postId,p.user.userNickname,p.title,p.category,p.attachedFile,p.bookmark)" +
            "from Post p where p.postId=1")
    List<StudyListDto> findStudyListDto();

//    @Query("select p from Post p where p=Study.post")
//    List<Post> findStudy();

}
