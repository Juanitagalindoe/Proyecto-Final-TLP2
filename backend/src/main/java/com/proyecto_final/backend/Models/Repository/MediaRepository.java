package com.proyecto_final.backend.Models.Repository;

import com.proyecto_final.backend.Models.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findByPost_Id(String postId);

    List<Media> findByTipo(String tipo);
}
