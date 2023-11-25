package com.example.entrystasker.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "statuslevel")
public class StatusLevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private Long id;
    private String nameStatus;

}
