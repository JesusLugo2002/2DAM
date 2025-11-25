package com.docencia.rest.service.interfaces;

import java.util.List;

import com.docencia.rest.exceptions.ResourceNotFoundException;
import com.docencia.rest.model.User;

public interface UserServiceInterface {

    List<User> getAllUsers();

    User getUserById(int userId) throws ResourceNotFoundException;

    User createUser(User user);

    User updateUser(int userId,
            User userDetails) throws ResourceNotFoundException;

    boolean deleteUser(int userId) throws ResourceNotFoundException;

}