package com.mercury.gateway.service;

import com.mercury.gateway.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public User info() {
        return new User("Kenny",20,"shanghai");
    }
}
