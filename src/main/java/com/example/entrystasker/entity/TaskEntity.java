package com.example.entrystasker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long id;
    private String taskName;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "task")
    private List<SubTasksEntity> subtasksList;

    private String status;

    private String urgency;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
