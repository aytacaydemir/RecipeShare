package com.aytac.recipeshare.service;

import com.aytac.recipeshare.exception.UserNotFoundException;
import com.aytac.recipeshare.model.User;
import com.aytac.recipeshare.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserById(String userId){
        return userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException("There is no user with this id = " +userId));
    }
}
