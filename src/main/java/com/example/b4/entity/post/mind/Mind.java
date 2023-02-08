package com.example.b4.entity.post.mind;

import com.example.b4.entity.BaseEntity;
import com.example.b4.entity.post.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class Mind extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mindId;

    @OneToOne(fetch = FetchType.LAZY)
    private Post post;

    private String mindDetails;
    private MindStatus status;
    @Builder
    public Mind(Post post, String mindDetails, MindStatus status) {
        this.post = post;
        this.mindDetails = mindDetails;
        this.status = status;
    }
}
