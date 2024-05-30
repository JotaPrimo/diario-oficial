package com.jotasantos.app.diariooficial.services.implementation;

import com.jotasantos.app.diariooficial.database.repositories.IEnderecoRepository;
import com.jotasantos.app.diariooficial.database.repositories.IOrgaoGovernamentalRepository;
import com.jotasantos.app.diariooficial.entities.Endereco;
import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import com.jotasantos.app.diariooficial.enums.EnumTipoOrgaoGov;
import com.jotasantos.app.diariooficial.exceptions.handler.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IOrgaoGovernamentalService;
import com.jotasantos.app.diariooficial.web.dtos.implementations.orgao_governamentals.OrgaoCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrgaoGovernamentalServiceImpl implements IOrgaoGovernamentalService {

    @Autowired
    private IOrgaoGovernamentalRepository orgaoGovernamentalRepository;

    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Override
    public List<OrgaoGovernamental> findAll() {
        return orgaoGovernamentalRepository.findAll();
    }

    @Override
    public List<OrgaoGovernamental> findAllSortedById() {
        return orgaoGovernamentalRepository.findAllOrderById();
    }

    @Override
    public OrgaoGovernamental findById(Long id) {
        return orgaoGovernamentalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Orgão Governamental com ID %d não encontrado", id)));
    }

    @Override
    public OrgaoGovernamental findOrFail(Long id) throws EntityNotFoundException {
        return orgaoGovernamentalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Orgão Governamental com ID %d não encontrado", id)));
    }

    @Override
    public OrgaoGovernamental save(OrgaoGovernamental orgaoGovernamental) {
        return orgaoGovernamentalRepository.save(orgaoGovernamental);
    }

    @Transactional
    @Override
    public OrgaoGovernamental saveWithEndereco(OrgaoGovernamental orgaoGovernamental) {
        Endereco enderecoSaved = enderecoRepository.save(orgaoGovernamental.getEndereco());
        orgaoGovernamental.setEndereco(enderecoSaved);
        return orgaoGovernamentalRepository.save(orgaoGovernamental);
    }

    @Override
    public OrgaoGovernamental update(OrgaoGovernamental entity, Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(OrgaoGovernamental entity) throws EntityNotFoundException {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Long> findAllIds() {
        return orgaoGovernamentalRepository.findAllIds();
    }

    @Override
    public String definirNome(OrgaoCreateDTO orgaoCreateDTO) {
        String nome = "";
        if (EnumTipoOrgaoGov.PREFEITURA_MUNICIPAL.getDescricao().equalsIgnoreCase(orgaoCreateDTO.tipo_orgao_governamental())) {
            nome = nome + EnumTipoOrgaoGov.PREFEITURA_MUNICIPAL.getDescricao() + orgaoCreateDTO.cidade();
        }

        if (EnumTipoOrgaoGov.GOVERNADORIA_ESTADUAL.getDescricao().equalsIgnoreCase(orgaoCreateDTO.tipo_orgao_governamental())) {
            nome = nome + EnumTipoOrgaoGov.GOVERNADORIA_ESTADUAL.getDescricao() + orgaoCreateDTO.estado();
        }
        return nome;
    }

}
