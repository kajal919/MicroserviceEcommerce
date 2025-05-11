package com.scaler.userservicejan31capstone.security.services;

import com.scaler.userservicejan31capstone.Repositories.UserRepository;
import com.scaler.userservicejan31capstone.models.User;
import com.scaler.userservicejan31capstone.security.models.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException(username);
        }
        User userDetails = user.get();

        return new CustomUserDetails(userDetails);
    }
}
