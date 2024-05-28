package com.jotasantos.app.diariooficial.web.dtos.implementations.usuario;

import com.jotasantos.app.diariooficial.entities.Role;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCreateDTO(

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
        String role
) {
    public static Usuario toEntity(UsuarioCreateDTO usuarioCreateDTO, Role role1) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioCreateDTO.username);
        usuario.setEmail(usuarioCreateDTO.email);
        usuario.setPassword(usuarioCreateDTO.password);
        usuario.setStatusUsuario(EnumStatusUsuario.INATIVO);
        usuario.setRole(role1);
        return usuario;
    }

    public static UsuarioCreateDTO getNewInstance() {
        return new UsuarioCreateDTO("", "", "", "");
    }

}
