package com.jotasantos.app.diariooficial.services.implementation;

import com.jotasantos.app.diariooficial.database.repositories.IUsuarioRepository;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import com.jotasantos.app.diariooficial.exceptions.handler.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

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
        usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));
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

    @Override
    public void inativarUsuario(Long id) {
        Usuario usuario = findOrFail(id);
        usuario.setStatusUsuario(EnumStatusUsuario.INATIVO);
        usuarioRepository.save(usuario);
    }

    @Override
    public void ativarUsuario(Long id) {
        Usuario usuario = findOrFail(id);
        usuario.setStatusUsuario(EnumStatusUsuario.ATIVO);
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findByEmail(String email) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);

        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        }

        return null;
    }

}
