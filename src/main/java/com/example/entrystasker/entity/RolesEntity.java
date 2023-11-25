package com.example.entrystasker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;
    private String nameRole;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    private List<UserEntity> user;
}
