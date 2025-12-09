package com.proyecto_final.backend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LikeDTO {

    @NotBlank(message = "El ID del post no puede estar vacío")
    private String postId;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
