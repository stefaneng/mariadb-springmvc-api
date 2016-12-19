package com.stefanengineering;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @RequestMapping("/")
    public String rootPage() {
        return "Example";
    }
}
