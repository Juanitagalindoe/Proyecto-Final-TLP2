package com.proyecto_final.backend.Models.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto_final.backend.Models.Entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 
    // Buscar un usuario por su username
    Optional<Usuario> findByUsername(String username);

    // Buscar usuarios cuyo nombre sea exactamente igual
    List<Usuario> findByNombre(String nombre);

    // Buscar por nombre ignorando mayúsculas / minúsculas
    List<Usuario> findByNombreIgnoreCase(String nombre);

    // Buscar usuarios que contengan parte del nombre
    List<Usuario> findByNombreContaining(String nombre);

    // Buscar por email
    Optional<Usuario> findByEmail(String email);

    // Buscar por username o email
    Optional<Usuario> findByUsernameOrEmail(String username, String email);

    // Verificar si existe un username
    boolean existsByUsername(String username);

    // Verificar si existe un email
    boolean existsByEmail(String email);
}