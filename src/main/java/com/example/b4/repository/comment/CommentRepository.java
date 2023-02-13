package com.example.b4.repository.comment;

import com.example.b4.dto.comment.CommentDto;
import com.example.b4.dto.study.StudyListDto;
import com.example.b4.entity.post.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select new com.example.b4.dto.comment.CommentDto(c.commentDetail,c.commentDetail, c.commentAttachedFile, c.createdDate,1,1) " +
            "from Comment c join c.post p where c.post.postId = :postId")
    public List<CommentDto> findAllByPostId(@Param("postId") Long postId);

    @Query("select count (c) " +
            "from Comment c join c.post p where c.post.postId = :postId")
    public Long countCommentByPostId(@Param("postId") Long postId);


}
