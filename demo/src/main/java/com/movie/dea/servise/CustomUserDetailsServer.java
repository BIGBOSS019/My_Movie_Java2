package com.movie.dea.servise;

import com.movie.dea.entity.User;
import com.movie.dea.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServer implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsServer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean user = userRepository.findByUsername(username);

        return org.springframework.security.core.userdetails.User.withUsername(String.valueOf(user))
                .password(String.valueOf(user))
                .roles(String.valueOf(user))
                .build();
    }
}