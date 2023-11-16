package com.example.practice4.service;

import com.example.practice4.entity.User;
import com.example.practice4.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User save(User user){
        return userRepo.save(user);
    }
    public void deleteById(Long userId){
        userRepo.deleteById(userId);
    }
    public User getById(Long userId){
        return userRepo.findById(userId).orElse(new User());
    }
}
