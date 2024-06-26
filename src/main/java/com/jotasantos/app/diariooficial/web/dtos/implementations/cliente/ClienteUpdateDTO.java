package com.jotasantos.app.diariooficial.web.dtos.implementations.cliente;

import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteUpdateDTO(

        @NotBlank(message = "Nome é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Nome deve ter entre {min} e {max} caracteres")
        String nome,

        @NotBlank(message = "Email é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Email deve ter entre {min} e {max} caracteres")
        String email,

        @NotBlank(message = "Password é um campo obrigatório")
        @Size(min = 10, max = 10, message = "Password deve ter entre {min} e {max} caracteres")
        String password
) {
    public static Usuario toEntity(ClienteUpdateDTO usuarioCreateDTO) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioCreateDTO.email);
        usuario.setPassword(usuarioCreateDTO.password);
        usuario.setStatusUsuario(EnumStatusUsuario.INATIVO);
        return usuario;
    }

    public static ClienteUpdateDTO getNewInstance() {
        return new ClienteUpdateDTO("", "", "");
    }

}
