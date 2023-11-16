package com.example.practice4.controller;

import com.example.practice4.entity.IdWrapper;
import com.example.practice4.entity.User;
import com.example.practice4.service.UserService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String getCreatePage(){
        return "create";
    }
    @GetMapping("/update")
    public String getUpdatePage(){
        return "update";
    }
    @GetMapping("/read")
    public String getReadPage(){
        return "read";
    }
    @GetMapping("/delete")
    public String getDeletePage(){
        return "delete";
    }

    @MessageMapping("/users/create")
    @SendTo("/topic/response")
    public User createUser(User user) {
        return userService.save(user);
    }

    @MessageMapping("/users/update")
    @SendTo("/topic/response")
    public User updateUser(User user) {
        return userService.save(user);
    }

    @MessageMapping("/users/delete")
    @SendTo("/topic/response")
    public IdWrapper deleteUser(IdWrapper idWrapper) {
        userService.deleteById(idWrapper.getId());
        return idWrapper;
    }
    @MessageMapping("/users/read")
    @SendTo("/topic/response")
    public User getUser(IdWrapper idWrapper) {
        return userService.getById(idWrapper.getId());
    }
}