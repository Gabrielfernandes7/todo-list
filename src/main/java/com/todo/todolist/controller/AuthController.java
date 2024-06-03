package com.todo.todolist.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todolist.entity.User;
import com.todo.todolist.entity.dto.UserRequestLoginDTO;
import com.todo.todolist.entity.dto.UserRequestRegisterDTO;
import com.todo.todolist.entity.dto.UserResponseDTO;
import com.todo.todolist.repository.UserRepository;
import com.todo.todolist.security.TokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestLoginDTO body) {
        User user = repository.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(body.senha(), user.getSenha())) {
            String token = generateToken(user);
            return ResponseEntity.ok(new UserResponseDTO(user.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestRegisterDTO body) {
        Optional<User> existingUser = repository.findByEmail(body.email());

        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        User newUser = new User();
        newUser.setSenha(encodePassword(body.senha()));
        newUser.setEmail(body.email());
        newUser.setNome(body.nome());
        repository.save(newUser);

        String token = generateToken(newUser);
        return ResponseEntity.ok(new UserResponseDTO(newUser.getNome(), token));
    }

    private String encodePassword(String senha) {
        return passwordEncoder.encode(senha);
    }

    private String generateToken(User user) {
        return tokenService.generateToken(user);
    }
}
