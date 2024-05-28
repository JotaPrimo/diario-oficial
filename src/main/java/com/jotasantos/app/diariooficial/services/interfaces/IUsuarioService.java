package com.jotasantos.app.diariooficial.services.interfaces;

import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import com.jotasantos.app.diariooficial.exceptions.handler.EntityNotFoundException;
import com.jotasantos.app.diariooficial.web.dtos.implementations.usuario.UsuarioSearchDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUsuarioService extends IServiceBase<Usuario, Long> {

    PasswordEncoder passwordEncoder();

    List<Usuario> search(UsuarioSearchDTO searchDto);

    void inativarUsuario(Long id) throws EntityNotFoundException;

    void ativarUsuario(Long id) throws EntityNotFoundException;

    Usuario findByEmail(String email);

    List<EnumStatusUsuario> returnAllStatusUsuario();
}
