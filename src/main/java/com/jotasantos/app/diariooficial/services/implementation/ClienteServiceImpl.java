package com.jotasantos.app.diariooficial.services.implementation;

import com.jotasantos.app.diariooficial.database.repositories.IClienteRepository;
import com.jotasantos.app.diariooficial.entities.Cliente;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.exceptions.handler.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IClienteService;
import com.jotasantos.app.diariooficial.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Qualifier("usuarioServiceImpl")
    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> findAllSortedById() {
        return clienteRepository.findAllOrderById();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Cliente com ID %d não encontrado", id)));
    }

    @Override
    public Cliente findOrFail(Long id) throws EntityNotFoundException {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Cliente com ID %d não encontrado", id)));
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente, Long id) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            clienteRepository.save(cliente);
            return cliente;
        }

       throw new EntityNotFoundException(String.format("Cliente com ID %d não encontrado", id));
    }

    @Override
    public void delete(Cliente cliente) throws EntityNotFoundException {
        if (clienteRepository.existsById(cliente.getId())) {
            clienteRepository.delete(cliente);
        }

        throw new EntityNotFoundException(String.format("Cliente com ID %d não encontrado", cliente.getId()));
    }

    @Override
    public boolean existsById(Long id) {
        return clienteRepository.existsById(id);
    }

    @Transactional
    public Cliente createClienteUser(Cliente cliente) {
        try {
            Usuario usuariosaved = usuarioService.save(cliente.getUsuario());
            cliente.setUsuario(usuariosaved);
            clienteRepository.save(cliente);
            return cliente;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
