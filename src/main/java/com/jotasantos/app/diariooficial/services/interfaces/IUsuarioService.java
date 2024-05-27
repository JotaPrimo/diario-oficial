package com.jotasantos.app.diariooficial.services.interfaces;

import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.web.dtos.cliente.ClienteCreateDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public interface IUsuarioService extends IServiceBase<Usuario, Long> {

    PasswordEncoder passwordEncoder();

    void inativarUsuario(Long id) throws EntityNotFoundException;

    void ativarUsuario(Long id) throws EntityNotFoundException;

    Usuario findByEmail(String email);
}
