package com.example.b4.entity.post.study;

import com.example.b4.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class Study extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyId;

//    @OneToOne(mappedBy = )
//    private Post post;

    private String studyDetails;

    public Study(String studyDetails) {
        this.studyDetails = studyDetails;
    }
}
