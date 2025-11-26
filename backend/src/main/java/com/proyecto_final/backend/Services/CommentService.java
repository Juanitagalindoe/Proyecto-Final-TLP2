package com.proyecto_final.backend.Services;

import com.proyecto_final.backend.DTO.CreateCommentDTO;
import com.proyecto_final.backend.Exception.ResourceNotFoundException;
import com.proyecto_final.backend.Models.Entity.Comment;
import com.proyecto_final.backend.Models.Entity.Post;
import com.proyecto_final.backend.Models.Entity.Usuario;
import com.proyecto_final.backend.Models.Repository.CommentRepository;
import com.proyecto_final.backend.Models.Repository.PostRepository;
import com.proyecto_final.backend.Models.Repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UsuarioRepository usuarioRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UsuarioRepository usuarioRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Comment create(CreateCommentDTO dto) {

        Post post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new ResourceNotFoundException("Post no encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Comment comment = new Comment();
        comment.setContenido(dto.getContenido());
        comment.setFecha(new Date());
        comment.setPost(post);
        comment.setUsuario(usuario);

        return commentRepository.save(comment);
    }

    public List<Comment> getByPost(String postId) {
        return commentRepository.findByPostId(postId);
    }
}