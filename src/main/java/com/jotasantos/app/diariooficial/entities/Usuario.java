package com.jotasantos.app.diariooficial.entities;

import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'ATIVO' ")
    private EnumStatusUsuario statusUsuario;

    private String password;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Usuario() {
    }

    public Usuario(String nome, String password, String email) {
        this.nome = nome;
        this.password = password;
        this.email = email;
    }

    @PrePersist
    protected void onCreate() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public EnumStatusUsuario getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(EnumStatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isAtivo() {
        return EnumStatusUsuario.ATIVO.equals(getStatusUsuario());
    }

    public boolean isInativo() {
        return EnumStatusUsuario.INATIVO.equals(getStatusUsuario());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
