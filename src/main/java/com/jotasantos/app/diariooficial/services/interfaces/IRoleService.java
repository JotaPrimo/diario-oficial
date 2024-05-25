package com.jotasantos.app.diariooficial.services.interfaces;

import com.jotasantos.app.diariooficial.entities.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleService extends IServiceBase<Role, Long> {

    List<Role> findRolesCliente();

    List<Role> findRolesAdmin();
}
