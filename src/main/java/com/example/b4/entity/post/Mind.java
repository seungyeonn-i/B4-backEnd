package com.example.b4.entity.post;

import com.example.b4.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
public class Mind extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mindId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private Post post;

    private String mindDetails;
    private Boolean status;
    private String password;

    public void updateMindDetails(String mindDetails) {
        this.mindDetails = mindDetails;
    }

    public void updateStatus(Boolean status) {
        this.status = status;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
