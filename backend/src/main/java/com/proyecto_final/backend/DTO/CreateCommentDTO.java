package com.proyecto_final.backend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateCommentDTO {

    @NotBlank
    private String contenido;

    @NotBlank
    private String postId;

    @NotNull
    private Long usuarioId;

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
