package com.movieFlix.moviefliex.controller;

import com.movieFlix.moviefliex.config.TokenService;
import com.movieFlix.moviefliex.controller.request.LoginRequest;
import com.movieFlix.moviefliex.controller.request.UserRequest;
import com.movieFlix.moviefliex.controller.response.LoginResponse;
import com.movieFlix.moviefliex.controller.response.UserResponse;
import com.movieFlix.moviefliex.entity.User;
import com.movieFlix.moviefliex.exception.UserNameOrPasswordInvalidException;
import com.movieFlix.moviefliex.mapper.UserMapper;
import com.movieFlix.moviefliex.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    //salve: user + email + password
    @PostMapping("/register")
    public ResponseEntity<UserResponse>  register(@RequestBody UserRequest request) {
        User savedUser = userService.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse>  login(@RequestBody LoginRequest request) {

        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authenticate = authenticationManager.authenticate(userAndPass);

            User user = (User) authenticate.getPrincipal(); //usuario autenticado

            //gerar o token JWT
            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));

        } catch (BadCredentialsException e) {
            throw new UserNameOrPasswordInvalidException("Usuario ou senha invalida."); //created new class
        }

    }


}
