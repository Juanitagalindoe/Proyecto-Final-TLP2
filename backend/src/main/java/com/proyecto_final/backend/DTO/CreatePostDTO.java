package com.proyecto_final.backend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreatePostDTO {

    @NotBlank
    private String caption;

    @NotNull
    private Long usuarioId;

    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}