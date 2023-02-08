package com.example.b4.entity.post.play;

import com.example.b4.entity.BaseTimeEntity;
import com.example.b4.entity.post.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class Play extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playId;

//    @DiscriminatorColumn(name="DTYPE")
    @OneToOne(fetch = FetchType.LAZY)
    private Post post;

    private String submitLink;
    private Date dueTo;
    private String playDetails;

    @Enumerated(EnumType.STRING)
    private PlayStatus status;

    @Builder
    public Play(Post post, String submitLink, Date dueTo, String playDetails, PlayStatus status) {
        this.post = post;
        this.submitLink = submitLink;
        this.dueTo = dueTo;
        this.playDetails = playDetails;
        this.status = status;
    }
}
