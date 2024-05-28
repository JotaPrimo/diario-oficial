package com.jotasantos.app.diariooficial.web.dtos.usuario;

import com.jotasantos.app.diariooficial.entities.Role;
import com.jotasantos.app.diariooficial.entities.Usuario;
import com.jotasantos.app.diariooficial.enums.EnumStatusUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateDTO(

        @NotBlank(message = "Username é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Username deve ter entre {min} e {max} caracteres")
        String username,

        @NotBlank(message = "Nome é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Nome deve ter entre {min} e {max} caracteres")
        String nome,

        @NotBlank(message = "Email é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Email deve ter entre {min} e {max} caracteres")
        String email,

        @NotBlank(message = "Password é um campo obrigatório")
        @Size(min = 10, max = 10, message = "Password deve ter entre {min} e {max} caracteres")
        String password,

        @NotBlank(message = "Role é um campo obrigatório")
        String role
) {
    public static Usuario toEntity(UsuarioUpdateDTO usuarioCreateDTO, Role role) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioCreateDTO.username);
        usuario.setRole(role);
        usuario.setEmail(usuarioCreateDTO.email);
        usuario.setPassword(usuarioCreateDTO.password);
        usuario.setStatusUsuario(EnumStatusUsuario.INATIVO);
        return usuario;
    }

    public static UsuarioUpdateDTO getNewInstance() {
        return new UsuarioUpdateDTO("", "", "", "", "");
    }

}
