package com.example.entrystasker.service;

import com.example.entrystasker.dto.RegistrDto;
import com.example.entrystasker.entity.UserEntity;
import com.example.entrystasker.exception.UserAlreadyExistException;
import com.example.entrystasker.repository.RolesRepo;
import com.example.entrystasker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepo userRepo;
    RolesRepo rolesRepo;
    @Autowired
    public UserService(UserRepo userRepo, RolesRepo rolesRepo) {
        this.userRepo = userRepo;
        this.rolesRepo = rolesRepo;
    }
    public String createUser(UserEntity user){
        try {
            if(userRepo.findByName(user.getName())==null ||
               userRepo.findByEmail(user.getEmail())==null)
            {
                userRepo.save(user);
            }
            else {
                throw new UserAlreadyExistException("Такой пользователь уже существует");
            }
            return "User registered";
        }
        catch (UserAlreadyExistException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            return "Error createUser | " + e.getMessage();
        }
    }


}
