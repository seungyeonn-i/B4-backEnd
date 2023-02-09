package com.example.b4.entity.post;

import com.example.b4.entity.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper=false)
@Entity
public class Study extends Post {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long studyId;
    private String studyDetails;

    private Post post;

//    @Builder
    public Study(User user, String title, String category, String attachedFile, Boolean bookmark, String studyDetails) {
        super(user, title, category, attachedFile, bookmark);
        this.studyDetails = studyDetails;
    }

}
