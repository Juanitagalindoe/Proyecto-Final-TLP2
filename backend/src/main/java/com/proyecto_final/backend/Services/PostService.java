package com.proyecto_final.backend.Services;

import com.proyecto_final.backend.DTO.CreatePostDTO;
import com.proyecto_final.backend.Exception.ResourceNotFoundException;
import com.proyecto_final.backend.Models.Entity.Post;
import com.proyecto_final.backend.Models.Entity.Usuario;
import com.proyecto_final.backend.Models.Repository.PostRepository;
import com.proyecto_final.backend.Models.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UsuarioRepository usuarioRepository;

    public PostService(PostRepository postRepository, UsuarioRepository usuarioRepository) {
        this.postRepository = postRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Post create(CreatePostDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Post post = new Post(dto.getCaption(), usuario);

        return postRepository.save(post);
    }

    public List<Post> getAll() { return postRepository.findAll(); }

    public Post getById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post no existe"));
    }
}