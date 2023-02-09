package com.example.b4.entity.post;

import com.example.b4.entity.BaseTimeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Play extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playId;

//    @DiscriminatorColumn(name="DTYPE")
//    @OneToOne(fetch = FetchType.LAZY)
//    private Post post;

    private String submitLink;
    private Date dueTo;
    private String playDetails;

    @Enumerated(EnumType.STRING)
    private PlayStatus status;

}
