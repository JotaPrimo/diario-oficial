package com.jotasantos.app.diariooficial.services.interfaces;

import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import com.jotasantos.app.diariooficial.web.dtos.implementations.orgao_governamentals.OrgaoCreateDTO;

public interface IOrgaoGovernamentalService extends IServiceBase<OrgaoGovernamental, Long> {
    OrgaoGovernamental saveWithEndereco(OrgaoGovernamental entity);
    String definirNome(OrgaoCreateDTO orgaoCreateDTO);
}
