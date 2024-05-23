package com.jotasantos.app.diariooficial.services;

import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return usuario.get();
        }

        return null;
    }

    public Usuario findOrFail(Long id) throws RuntimeException {
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(String.format("Usuário {%s} não encontrado", id))));
        return usuario;
    }

    public void inativarUsuario(Long id) {
        Usuario usuario = findOrFail(id);
        usuario.setStatusUsuario(EnumStatusUsuario.INATIVO);

        usuarioRepository.save(usuario);
    }

    public void ativarUsuario(Long id) {
        Usuario usuario = findOrFail(id);
        usuario.setStatusUsuario(EnumStatusUsuario.ATIVO);

        usuarioRepository.save(usuario);
    }

}
