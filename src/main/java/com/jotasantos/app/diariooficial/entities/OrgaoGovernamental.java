package com.jotasantos.app.diariooficial.entities;

import com.jotasantos.app.diariooficial.enums.EnumSimNao;
import com.jotasantos.app.diariooficial.utils.DataUtil;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orgao_governamentals")
public class OrgaoGovernamental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    @OneToOne(mappedBy = "orgaoGovernamental", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "orgaoGovernamental", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diario> diarios = new ArrayList<>();

    @OneToMany(mappedBy = "orgaoGovernamental", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Arquivo> arquivos = new ArrayList<>();

    @OneToMany(mappedBy = "orgaoGovernamental", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'NAO' ")
    private EnumSimNao deletado;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        deletado = EnumSimNao.NAO;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Diario> getDiarios() {
        return diarios;
    }

    public void setDiarios(List<Diario> diarios) {
        this.diarios = diarios;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public EnumSimNao getDeletado() {
        return deletado;
    }

    public void setDeletado(EnumSimNao deletado) {
        this.deletado = deletado;
    }

    public String getCreatedAtFormatado() {
        return DataUtil.retornaDataFormatadaDMY(this.getCreatedAt());
    }

    public boolean isDeletado() {
        return EnumSimNao.NAO.name().equals(this.deletado.name());
    }

}
