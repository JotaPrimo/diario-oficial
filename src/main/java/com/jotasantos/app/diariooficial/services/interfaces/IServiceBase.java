package com.jotasantos.app.diariooficial.services.interfaces;

import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IServiceBase<E, Long> {

    List<E> findAll();

    List<E> findAllSortedById();

    E findById(Long id);

    E findOrFail(Long id)
            throws EntityNotFoundException;
    E save(E entity);

    E update(E entity, Long id) throws EntityNotFoundException;

    void delete(E entity) throws EntityNotFoundException;

    boolean existsById(Long id);

}
