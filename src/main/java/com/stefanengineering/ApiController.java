package com.stefanengineering;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping("/")
    public String rootPage() {
        return "Example";
    }

    @RequestMapping("/api/users")
    public Collection<User> listUsers() {
        return new LinkedList<>();
    }
}
