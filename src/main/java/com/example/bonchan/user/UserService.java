package com.example.bonchan.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> GetUsers() {
        return userRepository.findAll();
    }

    public boolean CheckUser(String username) {
        boolean isExist = userRepository.existsByUsername(username);
        return isExist;
    }

    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    public User UpdateUser(User user) {
        boolean isExist = userRepository.existsById(user.getId());
        if (isExist != false) {
            return null;
        }
        return userRepository.save(user);
    }

    public void DeleteUser(Long id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
        new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
