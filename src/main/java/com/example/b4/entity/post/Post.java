package com.example.b4.entity.post;

import com.example.b4.entity.BaseTimeEntity;
import com.example.b4.entity.post.play.PlayCategory;
import com.example.b4.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    @Enumerated(EnumType.STRING)
    private PlayCategory playCategory;

    private String AttachedFile;

    private Boolean bookmark;


}
