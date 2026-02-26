package com.pie.app.service;

import com.pie.app.model.LoginDto;
import com.pie.app.model.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
