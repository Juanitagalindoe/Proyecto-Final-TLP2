package com.proyecto_final.backend.Models.Repository;

import com.proyecto_final.backend.Models.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    // Lista de comentarios por ID del post
    List<Comment> findByPost_Id(String postId);

    // Lista por usuario
    List<Comment> findByUsuario_Id(Long usuarioId);
}
