package com.jotasantos.app.diariooficial.services.implementation;

import com.jotasantos.app.diariooficial.database.repositories.IDiarioRepository;
import com.jotasantos.app.diariooficial.entities.Diario;
import com.jotasantos.app.diariooficial.exceptions.handler.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiarioServiceImpl implements IDiarioService {

    @Autowired
    private IDiarioRepository diarioRepository;

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

    @Override
    public List<Long> findAllIds() {
        return diarioRepository.findAllIds();
    }
}
