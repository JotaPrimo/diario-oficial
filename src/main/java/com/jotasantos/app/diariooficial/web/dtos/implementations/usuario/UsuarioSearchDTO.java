package com.jotasantos.app.diariooficial.web.dtos.implementations.usuario;

import com.jotasantos.app.diariooficial.utils.UtilsValidators;
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
        return (UtilsValidators.longIsNullOrZero(id)) &&
                (UtilsValidators.stringIsNullOrEmpty(nome)) &&
                (UtilsValidators.stringIsNullOrEmpty(email)) &&
                (UtilsValidators.stringIsNullOrEmpty(status)) &&
                (UtilsValidators.stringIsNullOrEmpty(role));
    }

    @Override
    public boolean isAnyFieldFilled() {
        return !isEmpty();
    }

    public static UsuarioSearchDTO getNewEmptyInstance() {
        return new UsuarioSearchDTO(null, "", "", "", "");
    }

    public static UsuarioSearchDTO resolveUsuarioSearchDTO(UsuarioSearchDTO usuarioSearchDTO) {
        if (usuarioSearchDTO.isEmpty()) {
            return getNewEmptyInstance();
        }
        return usuarioSearchDTO;
    }
}
