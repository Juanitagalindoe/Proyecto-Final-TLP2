package com.proyecto_final.backend.Controllers;

import com.proyecto_final.backend.DTO.CreateUserDTO;
import com.proyecto_final.backend.Models.Entity.Usuario;
import com.proyecto_final.backend.Models.Repository.UsuarioRepository;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody CreateUserDTO dto) {

        if (usuarioRepository.existsByCorreo(dto.getCorreo())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El correo ya está registrado"));
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasena(dto.getContrasena());
        usuario.setCelular(dto.getCelular());
        usuario.setRegistro(new Date());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @GetMapping
    public ResponseEntity<?> all() {
    return ResponseEntity.ok(usuarioRepository.findAll());
    }


    // HEAD
    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Void> head() {
        return ResponseEntity.ok().build();
    }

    // OPTIONS
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> options() {
        return ResponseEntity.ok().build();
    }
}
