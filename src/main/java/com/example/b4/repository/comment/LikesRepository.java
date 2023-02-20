package com.example.b4.repository.comment;

import com.example.b4.entity.User;
import com.example.b4.entity.post.Comment;
import com.example.b4.entity.post.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
//    Long countLikesByCommentIdAndLikesStatus(Long commentId, String status);

    @Query("select count(l.likesId) from Likes l join l.comment c where c.commentId =:commentId " +
            "and c.commentId=l.comment.commentId and l.likesStatus=:status")
    Long countLikes(@Param("commentId") Long commentId, @Param("status") String status);

    @Modifying
    @Query("delete  from Likes l where l.user.id = :userId")
    void deleteLikesByUser(@Param("userId") Long userId);


    Optional<Likes> findLikesByCommentAndUser(Comment comment, User user);

}
