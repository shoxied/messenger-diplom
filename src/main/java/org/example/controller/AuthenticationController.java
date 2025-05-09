package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @GetMapping("/register")
    public String register(@RequestParam(name = "email") String email,
                           @RequestParam(name = "phone_number") String phone_number,
                           @RequestParam(name = "first_name") String first_name,
                           @RequestParam(name = "last_name") String last_name,
                           @RequestParam(name = "password") String password){


    }
}
