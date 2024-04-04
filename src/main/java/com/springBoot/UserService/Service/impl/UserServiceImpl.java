package com.springBoot.UserService.Service.impl;
import com.springBoot.UserService.Entity.User;
import com.springBoot.UserService.Exceptions.ResourceNotFoundException;
import com.springBoot.UserService.Repo.UserRepository;
import com.springBoot.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void updateUser(Long userId, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(userId);
        existingUser.ifPresent(user -> {
//            user.setUsername(updatedUser.getName());
//            user.setEmail(updatedUser.getEmail());
            // Set other properties as needed
            userRepository.save(user);
        });
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
