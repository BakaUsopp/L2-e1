package com.example.l2e1.services;


import com.example.l2e1.repositories.UserRepository;
import com.example.l2e1.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var u2 = userRepository.findUserByUsername(username);
        return u2.map(SecurityUser::new).orElseThrow(()-> new UsernameNotFoundException("Username Not Found " + username));
    }
}
