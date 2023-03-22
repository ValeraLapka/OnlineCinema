package ru.edu.bsu.onlinecinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.edu.bsu.onlinecinema.persistance.repository.UserRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findFirstByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }
}
