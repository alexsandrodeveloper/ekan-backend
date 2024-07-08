package br.com.ekan.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("ekan".equals(username)) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username("ekan")
                    .password("$2a$10$SgYy4F4HrKtf5ohK/U5h6OCEu8.2pnlL1V2kC9NT91aXrIBQMW0lu")
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}


