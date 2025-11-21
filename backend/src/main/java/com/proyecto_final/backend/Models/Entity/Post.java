package com.proyecto_final.backend.Models.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.xml.stream.events.Comment;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String contenido;

    //@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Column(name = "Publicacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicacion;

    // Usuario que hizo la publicación
    @ManyToOne
    @JoinColumn(name = "Usuario")
    private Usuario usuario;

    // Comentarios
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comentarios;

    // Likes
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes;

    // Archivos multimedia
    @OneToMany(mappedBy = "post")
    private List<MediaFile> media;



}
