package com.example.entrystasker.service;

import com.example.entrystasker.dto.LoginDto;
import com.example.entrystasker.dto.RegistrDto;
import com.example.entrystasker.entity.UserEntity;
import com.example.entrystasker.exception.UserAlreadyExistException;
import com.example.entrystasker.exception.UserNotFoundException;
import com.example.entrystasker.model.User;
import com.example.entrystasker.repository.RolesRepo;
import com.example.entrystasker.repository.UserRepo;
import jakarta.jws.soap.SOAPBinding;
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
    public String editUser(UserEntity user ,Long id){
        UserEntity userEntity = userRepo.findById(id).get();
        if (user.getName() != null){
            userEntity.setName(user.getName());
        }
        if (user.getEmail()!=null){
            userEntity.setEmail(user.getEmail());
        }
        if (user.getRole()!=null){
            userEntity.setRole(user.getRole());
        }
        userRepo.save(userEntity);
        return "Изменения сохранены!";
    }
    public User getUser(Long id) throws UserNotFoundException {
        if(userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.tomodel(userRepo.findById(id).get());
    }

    public String delUser(Long id) throws UserNotFoundException {
        if(userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("Пользователь не найдет");
        }
        userRepo.delete(userRepo.findById(id).get());
        return "Пользователь удален!";
    }
   /* public String authUser(LoginDto loginDto) throws UserNotFoundException {
        try
        {
            userRepo.findByNameAndPassword(loginDto.getLogin(),loginDto.getPassword());
                return "home";

        }

    }*/


}
