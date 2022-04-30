package com.example.registration.Config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UserSetup {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "root";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
    }

}
