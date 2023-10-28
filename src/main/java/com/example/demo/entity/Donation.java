package com.example.demo.entity;
import com.example.demo.validator.annotation.ValidUserId;
import com.example.demo.validator.annotation.ValidCategoryId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

@Data
@Entity
@Table(name="donation")
@SQLDelete( sql = "UPDATE donation SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Donation {
    private boolean deleted;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "donation_amount")
    private int donation_amount;

    @Column(name = "donation_message")
    private String donation_message;


    @Column(name = "created_date")
    private Date created_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fund_id", referencedColumnName = "id")
    @ValidUserId
    private Fund fund;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @ValidUserId
    private User user;
}
