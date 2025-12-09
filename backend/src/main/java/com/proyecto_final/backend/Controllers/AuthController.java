package com.proyecto_final.backend.Controllers;

import com.proyecto_final.backend.DTO.CreateUserDTO;
import com.proyecto_final.backend.DTO.LoginDTO;
import com.proyecto_final.backend.Models.Entity.Usuario;
import com.proyecto_final.backend.Services.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // REGISTRO
    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody CreateUserDTO dto) {
        Usuario usuario = authService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
}
