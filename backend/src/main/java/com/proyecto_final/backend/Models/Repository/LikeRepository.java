package com.proyecto_final.backend.Models.Repository;

import com.proyecto_final.backend.Models.Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, String> {
    Optional<Like> findByPostIdAndUsuarioId(String postId, Long usuarioId);
    long countByPostId(String postId);
}