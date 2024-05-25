package com.jotasantos.app.diariooficial.services.implementation;

import com.jotasantos.app.diariooficial.database.repositories.IRoleRepository;
import com.jotasantos.app.diariooficial.entities.Role;
import com.jotasantos.app.diariooficial.exceptions.EntityNotFoundException;
import com.jotasantos.app.diariooficial.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> findAllSortedById() {
        return roleRepository.findAllOrderById();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Role com ID %d não encontrado", id)));
    }

    @Override
    public Role findOrFail(Long id) throws EntityNotFoundException {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Role com ID %d não encontrado", id)));
    }

    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Role update(Role role, Long id) throws EntityNotFoundException {
        if (this.existsById(id)) {
            role.setId(id);
            return roleRepository.save(role);
        }
        throw new EntityNotFoundException(String.format("Usuário com ID %d não encontrado", id));
    }

    @Override
    public void delete(Role entity) throws EntityNotFoundException {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Role> findRolesCliente() {
        return List.of();
    }

    @Override
    public List<Role> findRolesAdmin() {
        return List.of();
    }
}
