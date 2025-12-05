package com.proyecto_final.backend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreatePostDTO {

    @NotBlank(message = "La publicación no puede estar vacía")
    @Size(max = 300, message = "La publicación no puede tener más de 300 caracteres")
    private String caption;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
