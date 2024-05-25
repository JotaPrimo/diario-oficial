package com.jotasantos.app.diariooficial.services.implementation;

import com.jotasantos.app.diariooficial.entities.Endereco;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IEnderecoService;
import com.jotasantos.app.diariooficial.services.interfaces.IServiceBase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements IEnderecoService {

    @Override
    public List<Endereco> findAll() {
        return null;
    }

    @Override
    public List<Endereco> findAllSortedById() {
        return null;
    }

    @Override
    public Endereco findById(Long id) {
        return null;
    }

    @Override
    public Endereco findOrFail(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public Endereco save(Endereco entity) {
        return null;
    }

    @Override
    public Endereco update(Endereco entity, Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Endereco entity) throws EntityNotFoundException {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
