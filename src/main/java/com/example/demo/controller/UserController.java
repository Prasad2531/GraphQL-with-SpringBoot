package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }
    //create user
    @MutationMapping
    public User createUser(@Argument String name,@Argument String password){
        User user  = new User();
        user.setName(name);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument int userId,@Argument String name,
                           @Argument String password){
        User user = userService.getUserById(userId);
        if(name!=null)
            user.setName(name);
        if(password!=null)
            user.setPassword(password);
        return userService.updateUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }
    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getUserById(userId);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument int userId){
        return userService.deleteUserById(userId);
    }
}
