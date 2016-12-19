package com.stefanengineering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ApiController {

    private final UserRepository userRepository;

    @Autowired
    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }
}
