package com.jotasantos.app.diariooficial.enums;

public enum EnumTipoOrgaoGov {
    PREFEITURA_MUNICIPAL("Prefeitura Municipal", "Prefeitura Municipal de "),
    GOVERNADORIA_ESTADUAL("Governadoria Estadual", "Governadoria Estadual de ");

    private final String nome;
    private final String descricao;

    EnumTipoOrgaoGov(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
