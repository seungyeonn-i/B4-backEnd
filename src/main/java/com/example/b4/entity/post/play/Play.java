package com.example.b4.entity.post.play;

import com.example.b4.entity.BaseTimeEntity;
import com.example.b4.entity.post.Post;
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
    @OneToOne
    private Post post;

    private String submitLink;
    private Date dueTo;
    private String playDetails;

    @Enumerated(EnumType.STRING)
    private PlayStatus status;








}
