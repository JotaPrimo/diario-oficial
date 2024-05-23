package com.jotasantos.app.diariooficial.repositories;

import com.jotasantos.app.diariooficial.entities.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArquivoRepository extends JpaRepository<Arquivo, Long> {
}
