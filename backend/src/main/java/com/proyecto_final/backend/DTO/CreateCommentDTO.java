package com.proyecto_final.backend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCommentDTO {

    @NotBlank(message = "El comentario no puede estar vacío")
    @Size(max = 500, message = "El comentario no puede tener más de 500 caracteres")
    private String contenido;

    @NotBlank(message = "El ID del post es obligatorio")
    private String postId;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
