package com.jotasantos.app.diariooficial.repositories;

import com.jotasantos.app.diariooficial.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {
}
