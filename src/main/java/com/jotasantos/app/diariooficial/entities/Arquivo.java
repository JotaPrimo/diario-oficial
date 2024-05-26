package com.jotasantos.app.diariooficial.entities;

import com.jotasantos.app.diariooficial.enums.EnumSimNao;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "arquivos")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgao_governamental_id")
    private OrgaoGovernamental orgaoGovernamental;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'NAO' ")
    private EnumSimNao baixado;

    private String path;

    private String fileName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'NAO' ")
    private EnumSimNao deletado;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Arquivo() {
    }

    @PrePersist
    protected void onCreate() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }

    public boolean isBaixado() {
        return EnumSimNao.SIM.equals(this.getBaixado());
    }

    public boolean isNaoBaixado() {
        return EnumSimNao.NAO.equals(this.getBaixado());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumSimNao getBaixado() {
        return baixado;
    }

    public void setBaixado(EnumSimNao baixado) {
        this.baixado = baixado;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EnumSimNao getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumSimNao deletado) {
        this.deletado = deletado;
    }
}
