package com.jotasantos.app.diariooficial.web.dtos.implementations.usuario;

import com.jotasantos.app.diariooficial.web.dtos.interfaces.IRecordSearch;

public record UsuarioSearchDTO(
        Long id,
        String nome,
        String email,
        String status,
        String role
) implements IRecordSearch {

    @Override
    public boolean isEmpty() {
        return (id == null) &&
                (email == null || email.isBlank()) &&
                (status == null || status.isBlank()) &&
                (role == null || role.isBlank());
    }

    @Override
    public boolean isAnyFieldFilled() {
        return !isEmpty();
    }

    public static UsuarioSearchDTO getNewEmptyInstance() {
        return new UsuarioSearchDTO(null, "", "", "", "");
    }
}
