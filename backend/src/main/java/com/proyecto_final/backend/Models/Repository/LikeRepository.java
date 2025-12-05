package com.proyecto_final.backend.Models.Repository;

import com.proyecto_final.backend.Models.Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, String> {

    Optional<Like> findByPost_IdAndUsuario_Id(String postId, Long usuarioId);

    long countByPost_Id(String postId);

    List<Like> findByUsuario_Id(Long usuarioId);

    List<Like> findByPost_Id(String postId);
}
