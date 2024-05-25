package com.jotasantos.app.diariooficial.database.seeders;

import com.jotasantos.app.diariooficial.database.repositories.IRoleRepository;
import com.jotasantos.app.diariooficial.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {

    @Autowired
   private IRoleRepository roleRepository;


    public void populateRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        roleRepository.save(roleAdmin);

        Role roleColaborador = new Role();
        roleColaborador.setName("COLABORADOR");
        roleRepository.save(roleColaborador);

        Role roleClienteAdmin = new Role();
        roleClienteAdmin.setName("CLIENTE_ADMIN");
        roleRepository.save(roleClienteAdmin);

        Role roleCliente = new Role();
        roleCliente.setName("CLIENTE_COLABORADOR");
        roleRepository.save(roleCliente);
    }

}
