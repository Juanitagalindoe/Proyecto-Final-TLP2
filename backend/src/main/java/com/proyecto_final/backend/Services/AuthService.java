package com.proyecto_final.backend.Services;

import com.proyecto_final.backend.DTO.CreateUserDTO;
import com.proyecto_final.backend.DTO.LoginDTO;
import com.proyecto_final.backend.Exception.ResourceNotFoundException;
import com.proyecto_final.backend.Models.Entity.Usuario;
import com.proyecto_final.backend.Models.Repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Registro seguro
    public Usuario register(CreateUserDTO dto) {

        if (usuarioRepository.existsByCorreo(dto.getCorreo())) {
            throw new IllegalArgumentException("Correo ya registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setCorreo(dto.getCorreo());
        usuario.setCelular(dto.getCelular());
        usuario.setRegistro(new Date());

        // Encriptar contraseña
        usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));

        return usuarioRepository.save(usuario);
    }

    // Login
    public Usuario login(LoginDTO dto) {

        Usuario usuario = usuarioRepository.findByCorreo(dto.getCorreo())
                .orElseThrow(() -> new ResourceNotFoundException("Correo no registrado"));

        boolean correct = passwordEncoder.matches(dto.getContrasena(), usuario.getContrasena());

        if (!correct) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }

        return usuario;
    }
}
