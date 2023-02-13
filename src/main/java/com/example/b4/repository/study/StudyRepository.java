package com.example.b4.repository.study;

import com.example.b4.dto.study.StudyDetailDto;
import com.example.b4.dto.study.StudyListDto;
import com.example.b4.entity.post.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {
    @Query("select new com.example.b4.dto.study.StudyListDto(" +
            "p.postId,p.user.userNickname,p.title,p.category,p.attachedFile,p.bookmark,p.createdDate)" +
            "from Post p , Study s where p.postId=s.post.postId")
    List<StudyListDto> findStudyListDto();

    @Query("select new com.example.b4.dto.study.StudyListDto(" +
            "p.postId,p.title,p.category,p.attachedFile,p.bookmark)" +
            "from Post p , Study s where p.category = :category and p.postId = s.post.postId  ")
    List<StudyListDto> findStudyCategoryListDto(@Param("category") String category);

    @Query("select new com.example.b4.dto.study.StudyDetailDto(" +
            "p.category,p.title,p.category,s.studyDetails,p.attachedFile,p.createdDate)" +
            "from Post p, Study s where p.postId=s.post.postId")
    List<StudyDetailDto> findStudyDetailDto();

    @Query("select new com.example.b4.dto.study.StudyDetailDto(" +
            "p.category,p.title,p.category,s.studyDetails,p.attachedFile,p.createdDate)" +
            "from Post p, Study s where p.postId=:postId and p.postId=s.post.postId")
    StudyDetailDto findByPostIdDetailDto(@Param("postId")Long postId);


}