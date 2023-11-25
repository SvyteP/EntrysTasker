package com.example.entrystasker.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Data
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String password;
    private String email;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolesEntity role;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<TaskEntity> tasklist;


}
