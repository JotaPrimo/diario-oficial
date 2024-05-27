package com.jotasantos.app.diariooficial.services.interfaces;

import com.jotasantos.app.diariooficial.entities.Cliente;

public interface IClienteService extends IServiceBase<Cliente, Long>{
    Cliente createClienteUser(Cliente cliente);
}
