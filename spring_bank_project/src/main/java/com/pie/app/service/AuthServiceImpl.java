package com.pie.app.service;

import com.pie.app.entity.Roles;
import com.pie.app.entity.Users;
import com.pie.app.exception.BankException;
import com.pie.app.model.LoginDto;
import com.pie.app.model.RegisterDto;
import com.pie.app.repo.RolesRepository;
import com.pie.app.repo.UsersRpository;
import com.pie.app.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {



    private AuthenticationManager authenticationManager;
    private UsersRpository userRepository;
    private RolesRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UsersRpository userRepository,
                           RolesRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new BankException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByUsername(registerDto.getEmail())){
            throw new BankException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        Users user = new Users();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
       // user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Roles> roles = new HashSet<>();
        Roles userRole = roleRepository.findByName("USER_ROLE").get();
        roles.add(userRole);
        user.setRole(roles);

        userRepository.save(user);

        return "User registered successfully!.";
    }


}
