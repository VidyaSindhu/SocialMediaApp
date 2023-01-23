package com.vsd.SocialMediaApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping(path = "/users/all")
    public @ResponseBody Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path = "/users")
    public @ResponseBody String addNewUser(@RequestBody User user){
        userService.addUser(user);
        return "Saved";
    }
}
