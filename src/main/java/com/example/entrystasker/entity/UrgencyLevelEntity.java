package com.example.entrystasker.entity;

import jakarta.persistence.*;
import liquibase.license.LicenseService;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "urgencylevel")
public class UrgencyLevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "urgency_id")
    private Long id;
    private String urgencyName;

}
