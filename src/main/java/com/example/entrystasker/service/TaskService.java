/*
package com.example.entrystasker.service;

import com.example.entrystasker.exception.UserAlreadyExistException;
import com.example.entrystasker.exception.UserNotFoundException;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    public void registration (TaskEntity user) throws UserAlreadyExistException {

        if(taskRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("This name is reserved!");
        }

        return taskRepo.save(user);
    }

    public User GetOne (Long id) throws UserNotFoundException {
        if(userRepo.findById(id).isEmpty()){
            throw new UserNotFoundException("User not found!");
        }
        return User.toModel(userRepo.findById(id).get());
    }

    public void delete(Long id){
        userRepo.findById(id).orElseThrow();
        userRepo.deleteById(id);

    }
}
*/
