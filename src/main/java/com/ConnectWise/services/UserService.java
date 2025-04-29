package com.ConnectWise.services;

import com.ConnectWise.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);
    void deleteUser(String id);
    boolean isUserExist(String userId);
    boolean isUserExistByEmail(String email);

    User getUserByEmail(String email);
    List<User> getAllUser();



}
