package com.jotasantos.app.diariooficial.web.dtos.usuario;

import com.jotasantos.app.diariooficial.entities.Role;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import com.jotasantos.app.diariooficial.services.implementation.RoleServiceImpl;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCreateDTO(

        @NotBlank(message = "Email é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Email deve ter entre {min} e {max} caracteres")
        String email,

        @NotBlank(message = "Password é um campo obrigatório")
        @Size(min = 8, max = 10, message = "Password deve ter entre {min} e {max} caracteres")
        String password,

        @NotBlank(message = "Role é um campo obrigatório")
        String role
) {
    public static Usuario toEntity(UsuarioCreateDTO usuarioCreateDTO, Role role1) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioCreateDTO.email);
        usuario.setPassword(usuarioCreateDTO.password);
        usuario.setStatusUsuario(EnumStatusUsuario.INATIVO);
        usuario.setRole(role1);
        return usuario;
    }

    public static UsuarioCreateDTO getNewInstance() {
        return new UsuarioCreateDTO("", "", "");
    }

}
