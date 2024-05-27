package com.jotasantos.app.diariooficial.database.repositories;

import com.jotasantos.app.diariooficial.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends IRepositoryBase<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
