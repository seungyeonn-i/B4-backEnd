package com.example.b4.entity.post;

import com.example.b4.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class Advice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adviceId;

    @OneToOne
    private Post post;

    private String adviceDetails;
    private AdviceSecretStatus status;

}
