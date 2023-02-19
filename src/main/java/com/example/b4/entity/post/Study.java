package com.example.b4.entity.post;

import com.example.b4.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper=false)
@Entity
public class Study extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private Post post;
    private String studyDetails;

    public void updateStudyDetails(String studyDetails) {
        this.studyDetails = studyDetails;
    }

    public Study(Post post, String studyDetails) {
        this.post = post;
        this.studyDetails = studyDetails;
    }

    //    @Builder


}
