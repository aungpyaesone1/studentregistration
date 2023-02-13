package com.example.registration.Controller;

import com.example.registration.Dto.*;
import com.example.registration.Service.SiginService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class SigninController {
    @Autowired
    private SiginService siginService;
    @PostMapping("/login")
    public ResponseEntity<?> sigin(@RequestBody SiginData siginData){
        SiginResponse siginResponse = siginService.sigin(siginData);
        return ResponseEntity.ok().body(siginResponse);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterData registerData){
       BaseResponse response = siginService.register(registerData);
        return ResponseEntity.ok().body(response);
    }
}
