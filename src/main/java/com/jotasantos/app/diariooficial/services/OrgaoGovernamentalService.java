package com.jotasantos.app.diariooficial.services;

import com.jotasantos.app.diariooficial.entities.Endereco;
import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IServiceBase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgaoGovernamentalService implements IServiceBase<OrgaoGovernamental, Long> {
    @Override
    public List<OrgaoGovernamental> findAll() {
        return null;
    }

    @Override
    public List<OrgaoGovernamental> findAllSortedById() {
        return null;
    }

    @Override
    public OrgaoGovernamental findById(Long id) {
        return null;
    }

    @Override
    public OrgaoGovernamental findOrFail(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public OrgaoGovernamental save(OrgaoGovernamental entity) {
        return null;
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
