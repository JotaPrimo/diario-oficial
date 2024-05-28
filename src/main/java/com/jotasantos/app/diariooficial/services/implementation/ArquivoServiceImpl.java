package com.jotasantos.app.diariooficial.services.implementation;
import com.jotasantos.app.diariooficial.entities.Arquivo;
import com.jotasantos.app.diariooficial.exceptions.handler.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IArquivoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArquivoServiceImpl implements IArquivoService {


    @Override
    public List<Arquivo> findAll() {
        return List.of();
    }

    @Override
    public List<Arquivo> findAllSortedById() {
        return List.of();
    }

    @Override
    public Arquivo findById(Long id) {
        return null;
    }

    @Override
    public Arquivo findOrFail(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public Arquivo save(Arquivo entity) {
        return null;
    }

    @Override
    public Arquivo update(Arquivo entity, Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Arquivo entity) throws EntityNotFoundException {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
