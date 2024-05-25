package com.jotasantos.app.diariooficial.repositories;

import com.jotasantos.app.diariooficial.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends IRepositoryBase<Cliente, Long> {
}
