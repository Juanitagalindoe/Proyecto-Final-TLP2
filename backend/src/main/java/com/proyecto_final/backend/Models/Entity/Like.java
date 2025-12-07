package com.proyecto_final.backend.Models.Entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(
    name = "likes",
    uniqueConstraints = @UniqueConstraint(columnNames = {"post_id", "usuario_id"})
)
@JsonIgnoreProperties({"post", "usuario"})
public class Like implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties({"comments", "likes", "media"})
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"comments", "likes"})
    private Usuario usuario;

    public Like() {}

    public Like(Post post, Usuario usuario) {
        this.post = post;
        this.usuario = usuario;
    }

    // Getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
