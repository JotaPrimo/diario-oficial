package com.jotasantos.app.diariooficial.repositories;

import com.jotasantos.app.diariooficial.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u ORDER BY u.id")
    List<Usuario> findAllOrderById();

}
