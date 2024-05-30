package com.jotasantos.app.diariooficial.web.dtos.implementations.cliente;

import com.jotasantos.app.diariooficial.entities.Cliente;
import com.jotasantos.app.diariooficial.entities.OrgaoGovernamental;
import com.jotasantos.app.diariooficial.entities.Role;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteCreateDTO(

        @NotBlank(message = "Nome é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Nome deve ter entre {min} e {max} caracteres")
        String nome,

        @NotBlank(message = "Username é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Username deve ter entre {min} e {max} caracteres")
        String username,

        @NotBlank(message = "Email é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Email deve ter entre {min} e {max} caracteres")
        String email,

        @NotBlank(message = "Password é um campo obrigatório")
        @Size(min = 8, max = 10, message = "Password deve ter entre {min} e {max} caracteres")
        String password,

        @NotBlank(message = "Role é um campo obrigatório")
        String role,

        @NotBlank(message = "Role é um campo obrigatório")
        String id_orgao_gov
) {
    public static Cliente toEntity(ClienteCreateDTO clienteCreateDTO, Role role, OrgaoGovernamental orgaoGovernamental) {
        Usuario usuario1 = new Usuario();
        usuario1.setUsername(clienteCreateDTO.username);
        usuario1.setEmail(clienteCreateDTO.email);
        usuario1.setPassword(clienteCreateDTO.password);
        usuario1.setRole(role);
        usuario1.setStatusUsuario(EnumStatusUsuario.INATIVO);

        Cliente cliente = new Cliente();
        cliente.setUsuario(usuario1);
        cliente.setNome(clienteCreateDTO.nome());
        cliente.setOrgaoGovernamental(orgaoGovernamental);
        return cliente;
    }

    public static ClienteCreateDTO getNewInstance() {
        return new ClienteCreateDTO("", "", "", "", "", "");
    }

}
