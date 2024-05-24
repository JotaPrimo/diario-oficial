package com.jotasantos.app.diariooficial.services;

import com.jotasantos.app.diariooficial.entities.Diario;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IServiceBase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiarioService implements IServiceBase<Diario, Long> {
    @Override
    public List<Diario> findAll() {
        return null;
    }

    @Override
    public List<Diario> findAllSortedById() {
        return null;
    }

    @Override
    public Diario findById(Long id) {
        return null;
    }

    @Override
    public Diario findOrFail(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public Diario save(Diario entity) {
        return null;
    }

    @Override
    public Diario update(Diario entity, Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Diario entity) throws EntityNotFoundException {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
