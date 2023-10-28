package com.example.demo.entity;
import com.example.demo.validator.annotation.ValidUserId;
import com.example.demo.validator.annotation.ValidCategoryId;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="foundation")
@SQLDelete( sql = "UPDATE foundation SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Foundation {
    private boolean deleted;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "decription")
    private String decription;

    @Column(name = "img_url")
    private String img_url;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "foundation", cascade = CascadeType.ALL)
    private List<Fund> funds;
}
