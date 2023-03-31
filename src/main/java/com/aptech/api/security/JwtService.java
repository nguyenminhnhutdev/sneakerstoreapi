//package com.aptech.api.security;
//
//import com.aptech.api.entity.JwtRequest;
//import com.aptech.api.entity.JwtResponse;
//import com.aptech.api.entity.User;
//import com.aptech.api.repository.UserRepository;
//import com.aptech.api.util.JwtUtil;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//@NoArgsConstructor
//public class JwtService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByEmail(username)
//                .map(LibraryUserDetails::new)
//                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
//    }
//}
//
