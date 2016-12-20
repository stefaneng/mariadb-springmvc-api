package com.stefanengineering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    private final UserRepository userRepository;

    @Autowired
    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public Iterable<User> getUsers(@RequestParam(value = "firstname", required = false) String firstName,
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

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "api/adduser", method = RequestMethod.POST)
    public User insertUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
