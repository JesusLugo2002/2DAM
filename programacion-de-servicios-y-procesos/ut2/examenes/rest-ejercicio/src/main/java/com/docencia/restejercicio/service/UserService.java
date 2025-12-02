package com.docencia.restejercicio.service;

import org.springframework.stereotype.Service;

import com.docencia.restejercicio.model.User;
import com.docencia.restejercicio.repository.UserRepository;

@Service
public class UserService extends AbstractService<User> {

    public UserService(UserRepository repository) {
        setRepository(repository);
    }
    
}
