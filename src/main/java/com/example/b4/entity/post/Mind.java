package com.example.b4.entity.post;

import com.example.b4.entity.BaseEntity;
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


}
