package com.dimathicc.distinct.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "numbers")
public class Numbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private Instant timestamp;
    private String numbers;
    @Column(name = "distincts") // distinct - зарезервированное слово в SQL
    private String distinct;
}
