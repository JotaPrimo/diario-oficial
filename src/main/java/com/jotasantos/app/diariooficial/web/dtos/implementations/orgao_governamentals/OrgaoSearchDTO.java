package com.jotasantos.app.diariooficial.web.dtos.implementations.orgao_governamentals;

import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;

public record OrgaoSearchDTO(

        String nome,

        String cnpj
) {

    public static OrgaoGovernamental toEntity(OrgaoSearchDTO orgaoSearchDTO) {
        OrgaoGovernamental orgaoGovernamental = new OrgaoGovernamental();
        orgaoGovernamental.setNome(orgaoSearchDTO.nome);
        orgaoGovernamental.setCnpj(orgaoSearchDTO.cnpj);
        return orgaoGovernamental;
    }

    public static Object getNewInstance() {
        return new OrgaoSearchDTO("", "");
    }
}
