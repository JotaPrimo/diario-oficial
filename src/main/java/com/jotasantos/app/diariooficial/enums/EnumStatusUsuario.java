package com.jotasantos.app.diariooficial.enums;

import java.util.ArrayList;
import java.util.List;

public enum EnumStatusUsuario {
    ATIVO,
    INATIVO,
    SUSPENSO;

    public static List<EnumStatusUsuario> getAllEnumStatus() {
        List<EnumStatusUsuario> listStatus = new ArrayList<>();
        listStatus.add(ATIVO);
        listStatus.add(INATIVO);
        listStatus.add(SUSPENSO);
        return listStatus;
    }
}