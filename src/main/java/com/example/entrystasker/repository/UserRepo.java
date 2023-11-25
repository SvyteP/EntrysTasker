package com.example.entrystasker.repository;

import com.example.entrystasker.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {
    UserEntity findByNameAndPassword(String name ,String password);
    UserEntity findByName(String name);
    UserEntity findByEmail(String email);
}
