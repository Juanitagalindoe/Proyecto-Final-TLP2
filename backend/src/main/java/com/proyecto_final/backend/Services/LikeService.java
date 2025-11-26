package com.proyecto_final.backend.Services;

import com.proyecto_final.backend.DTO.LikeDTO;
import com.proyecto_final.backend.Exception.ResourceNotFoundException;
import com.proyecto_final.backend.Models.Entity.Like;
import com.proyecto_final.backend.Models.Entity.Post;
import com.proyecto_final.backend.Models.Entity.Usuario;
import com.proyecto_final.backend.Models.Repository.LikeRepository;
import com.proyecto_final.backend.Models.Repository.PostRepository;
import com.proyecto_final.backend.Models.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UsuarioRepository usuarioRepository;

    public LikeService(LikeRepository likeRepository, PostRepository postRepository, UsuarioRepository usuarioRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public String toggleLike(LikeDTO dto) {

        Optional<Like> existing = likeRepository.findByPostIdAndUsuarioId(dto.getPostId(), dto.getUsuarioId());

        if (existing.isPresent()) {
            likeRepository.delete(existing.get());
            return "removed";
        }

        Post post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new ResourceNotFoundException("Post no encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Like like = new Like(post, usuario);

        likeRepository.save(like);
        return "added";
    }

    public long countLikes(String postId) {
        return likeRepository.countByPostId(postId);
    }
}