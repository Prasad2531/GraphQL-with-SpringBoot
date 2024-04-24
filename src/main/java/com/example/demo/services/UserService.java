package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;
    private UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    //create new user
    public User createUser(User user){
        return userRepo.save(user);
    }
    //getting all users
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUserById(int userid){
        User user = userRepo.findById(userid).orElseThrow(()->new RuntimeException("User with id "+userid+" not found"));
        return user;
    }

    //updating user
    public User updateUser(User user){
        return userRepo.save(user);
    }
    //delete user
    public boolean deleteUserById(int userId){
        User user = userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        userRepo.delete(user);
        return true;
    }
}
