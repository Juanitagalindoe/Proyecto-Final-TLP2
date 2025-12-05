package com.proyecto_final.backend.Models.Repository;

import com.proyecto_final.backend.Models.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findByUsuario_Id(Long usuarioId);

    List<Post> findAllByOrderByPublicacionDesc();
}
