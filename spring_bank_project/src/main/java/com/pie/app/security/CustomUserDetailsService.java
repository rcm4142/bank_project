package com.pie.app.security;

import com.pie.app.entity.Users;
import com.pie.app.repo.UsersRpository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UsersRpository userRepository;

    public CustomUserDetailsService(UsersRpository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username" +username);
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() ->new UsernameNotFoundException("User not found with username or email: "+ username));


        Set<GrantedAuthority> authorities = user.getRole().stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new  org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

}
