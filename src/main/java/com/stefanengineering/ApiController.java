package com.stefanengineering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    private final UserRepository userRepository;

    @Autowired
    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/user")
    public Iterable<User> getUserByName(@RequestParam(value = "firstname", required = false) String firstName,
            @RequestParam(value = "lastname", required = false) String lastName) {
        logger.info("query for: firstname = {} lastname = {}", firstName, lastName);
        if (firstName != null && lastName != null)
            return userRepository.findByFirstNameAndLastName(firstName, lastName);
        else if (firstName != null)
            return userRepository.findByFirstName(firstName);
        else if (lastName != null)
            return userRepository.findByLastName(lastName);
        else
            return userRepository.findAll();
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userRepository.findOne(id);
    }
}
