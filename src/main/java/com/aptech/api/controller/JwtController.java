package com.aptech.api.controller;

import com.aptech.api.entity.JwtRequest;
import com.aptech.api.entity.JwtResponse;
import com.aptech.api.exception.UserNotFoundException;
import com.aptech.api.security.JwtService;
import com.aptech.api.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/authenticate")
public class JwtController {

    @Autowired
    private JwtUtil jwtUtil ;
    @Autowired
    private AuthenticationManager authenticationManager;
        @PostMapping
    public String getTokenForAuthenticatedUser(@RequestBody JwtRequest authRequest) throws Exception {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtUtil.generateToken(authRequest.getUserName());
            //return jwtService.createJwtToken(authRequest);
        }
        else {
            throw new UserNotFoundException("Invalid user credentials");
        }
    }

}
