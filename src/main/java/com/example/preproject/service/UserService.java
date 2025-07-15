package com.example.preproject.service;

import com.example.preproject.repository.User;
import com.example.preproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private List<User> users = new ArrayList<>();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String printUser() {
        return "Welcome to Spring Boot!";
    }

    public String printName(String name) {
        return "Hello, " + name;
    }

    public List<User> printUsersPrint() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
