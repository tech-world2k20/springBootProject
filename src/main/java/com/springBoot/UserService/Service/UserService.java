package com.springBoot.UserService.Service;

import com.springBoot.UserService.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    User addUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    void updateUser(Long userId, User updatedUser);

    void deleteUser(Long userId);
}
