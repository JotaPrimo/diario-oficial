package com.jotasantos.app.diariooficial.services;

import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.repositories.IUsuarioRepository;
import com.jotasantos.app.diariooficial.services.interfaces.IServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IServiceBase<Usuario, Long> {

    @Autowired
    private IUsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAllSortedById() {
        return usuarioRepository.findAllOrderById();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Cliente com ID %d não encontrado", id)));
    }

    @Override
    public Usuario findOrFail(Long id) throws EntityNotFoundException {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Usuario com ID %d não encontrado", id)));
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario, Long id) throws EntityNotFoundException {
        if (this.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        throw new EntityNotFoundException(String.format("Usuário com ID %d não encontrado", id));
    }

    @Override
    public void delete(Usuario usuario) throws EntityNotFoundException {
        if (usuarioRepository.existsById(usuario.getId())) {
            usuarioRepository.delete(usuario);
        }

        throw new EntityNotFoundException(String.format("Usuario com ID %d não encontrado", usuario.getId()));
    }

    @Override
    public boolean existsById(Long id)  {
        return usuarioRepository.existsById(id);
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
