package com.example.b4.entity.post;

import com.example.b4.entity.BaseTimeEntity;
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
    private String playAttachedFiles;

    @Enumerated(EnumType.STRING)
    private PlayStatus status;








}
