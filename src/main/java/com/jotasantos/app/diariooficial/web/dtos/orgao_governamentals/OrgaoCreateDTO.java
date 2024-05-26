package com.jotasantos.app.diariooficial.web.dtos.orgao_governamentals;

import com.jotasantos.app.diariooficial.entities.Endereco;
import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import com.jotasantos.app.diariooficial.enums.EnumTipoOrgaoGov;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record OrgaoCreateDTO(

        @NotBlank(message = "Selecione o tipo de orgão")
        String tipo_orgao_governamental,

        @NotBlank(message = "Nome é um campo obrigatório")
        @Length(min = 14, max = 14, message = "Nome deve ter entre {min} e {max} caracteres")
        String cnpj,

        @NotBlank(message = "Nome é um campo obrigatório")
        String logradouro,

        @NotBlank(message = "Bairro é um campo obrigatório")
        String bairro,

        @NotBlank(message = "Cidade é um campo obrigatório")
        String cidade,

        @NotBlank(message = "Nome é um campo obrigatório")
        String estado,

        @NotBlank(message = "Nome é um campo obrigatório")
        String cep
) {
    public static OrgaoGovernamental toEntity(OrgaoCreateDTO orgaoCreateDTO) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(orgaoCreateDTO.logradouro);
        endereco.setCidade(orgaoCreateDTO.cidade);
        endereco.setEstado(orgaoCreateDTO.estado);
        endereco.setCep(orgaoCreateDTO.cep);

        OrgaoGovernamental org = new OrgaoGovernamental();
        org.setCnpj(orgaoCreateDTO.cnpj);
        org.setEndereco(endereco);
        return org;
    }

    public static OrgaoCreateDTO getNewInstance() {
        return new OrgaoCreateDTO("", "", "", "", "", "", "");
    }

}
