package com.example.preproject.controller;

import com.example.preproject.repository.User;
import com.example.preproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("/greet")
//    public String printUser() {
//        return userService.printUser();
//    }
//
//    @GetMapping("/greet/{name}")
//    public String printName(@PathVariable("name") String name){
//        return userService.printName(name);
//    }
//
//    @GetMapping("/greet/usersPrint")
//    public List<User> printUsersPrint(){
//        return userService.printUsersPrint();
//    }
//
//    @PostMapping("/greet/users")
//    public void addUser(@RequestBody User user){
//        userService.save(user);
//    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id){
        User user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
