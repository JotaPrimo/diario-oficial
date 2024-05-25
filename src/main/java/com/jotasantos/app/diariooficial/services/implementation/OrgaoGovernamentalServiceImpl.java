package com.jotasantos.app.diariooficial.services.implementation;

import com.jotasantos.app.diariooficial.database.repositories.IOrgaoGovernamentalRepository;
import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IOrgaoGovernamentalService;
import com.jotasantos.app.diariooficial.services.interfaces.IServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgaoGovernamentalServiceImpl implements IOrgaoGovernamentalService {

    @Autowired
    private IOrgaoGovernamentalRepository orgaoGovernamentalRepository;

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
    public OrgaoGovernamental save(OrgaoGovernamental entity) {
        return orgaoGovernamentalRepository.save(entity);
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
}
