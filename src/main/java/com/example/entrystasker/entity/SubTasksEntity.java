package com.example.entrystasker.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "subtasks")
public class SubTasksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subtask_id")
    private Long id;

    private String task_name;

    private String status;

    private String urgency;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity task;
}