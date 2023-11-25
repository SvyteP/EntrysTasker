package com.example.entrystasker.repository;

import com.example.entrystasker.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {
    UserRepo findByNameAndPassword(String name ,String password);
    UserRepo findByName(String name);
    UserRepo findByEmail(String email);
}
