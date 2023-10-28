package com.example.demo.entity;
import com.example.demo.validator.annotation.ValidUserId;
import com.example.demo.validator.annotation.ValidCategoryId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="fund")
@SQLDelete( sql = "UPDATE fund SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Fund {
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

    @Column(name = "expected_result")
    private Long expected_result;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "end_date")
    private Date end_date;

    @OneToMany(mappedBy = "fund", cascade = CascadeType.ALL)
    private List<Donation> donations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name = "foundation_id")
    @ValidCategoryId
    private Foundation foundation;

}
