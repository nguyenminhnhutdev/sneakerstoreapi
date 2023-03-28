package com.aptech.api.controller;

import com.aptech.api.entity.JwtRequest;
import com.aptech.api.exception.UserNotFoundException;
import com.aptech.api.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/authenticate")
public class JwtController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping
    public ResponseEntity<?> getTokenForAuthenticatedUser(@RequestBody JwtRequest authRequest) throws Exception {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return new ResponseEntity<>(jwtUtil.generateToken(authRequest.getUserName()), HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Invalid user credentials");
        }
    }

}
