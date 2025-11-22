package com.proyecto_final.backend.Models.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String celular;

    @Column(name = "HBD")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cumple;

    @Column(name = "registro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)   
    private Date registro;

    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    private List<Like> likes;

    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    private List<Comment> comments;

    public Usuario() {}

    public Usuario(Long id, String nombre, String apellido, String correo, String contrasena, String celular,
            Date cumple, Date registro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.celular = celular;
        this.cumple = cumple;
        this.registro = registro;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public Date getCumple() { return cumple; }
    public void setCumple(Date cumple) { this.cumple = cumple; }

    public Date getRegistro() { return registro; }
    public void setRegistro(Date registro) { this.registro = registro; }

    public List<Like> getLikes() { return likes; }
    public void setLikes(List<Like> likes) { this.likes = likes; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
}
