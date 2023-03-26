package com.aptech.api.service;

import com.aptech.api.dto.UserDto;
import com.aptech.api.exception.UserAlreadyExistsException;
import com.aptech.api.exception.UserNotFoundException;
import com.aptech.api.entity.User;
import com.aptech.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    /**
     * Insert a user to data
     * @param user
     * @return
     */
    @Override
    public User add(User user) {
        Optional<User> theUser = userRepository.findByEmail(user.getEmail());
        if (theUser.isPresent()){
            throw new UserAlreadyExistsException("A user with " +user.getEmail() +" already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<UserRecord> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserRecord(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User update(User user) {
        user.setRoles(user.getRoles());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail()).get();
        user.setImage(user.getImage());
        user.setGender(user.getGender());
        user.setEmail(user.getEmail());
        user.setPhone(user.getPhone());
        user.setLastName(user.getLastName());
        user.setFirstName(user.getFirstName());
        return userRepository.save(user);

    }
}
