package com.example.b4.entity.post;

import com.example.b4.entity.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
public class Play extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playId;

//    @DiscriminatorColumn(name="DTYPE")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private Post post;

    private String submitLink;
    private LocalDateTime dueTo;
    private String playDetails;

//    @Enumerated(EnumType.STRING)
    private String status;

    public void updateSubmitLink(String submitLink) {
        this.submitLink = submitLink;
    }

    public void updateDueTo(LocalDateTime dueTo) {
        this.dueTo = dueTo;
    }

    public void updatePlayDetails(String playDetails) {
        this.playDetails = playDetails;
    }
}
