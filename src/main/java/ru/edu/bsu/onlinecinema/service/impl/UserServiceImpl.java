package ru.edu.bsu.onlinecinema.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.edu.bsu.onlinecinema.persistance.dto.UserDto;
import ru.edu.bsu.onlinecinema.persistance.model.User;
import ru.edu.bsu.onlinecinema.persistance.repository.UserRepository;
import ru.edu.bsu.onlinecinema.service.UserService;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findFirstByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }

    @Override
    public void registration(UserDto userDto) {
        var user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getUserByAuthContext() {
        return userRepository.findFirstByUsername(getCurrentUsername())
                .orElseThrow(()->new RuntimeException("user not found"));
    }


    private String getCurrentUsername() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
