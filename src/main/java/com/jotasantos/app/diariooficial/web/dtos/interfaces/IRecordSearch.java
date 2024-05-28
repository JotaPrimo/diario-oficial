package com.jotasantos.app.diariooficial.web.dtos.interfaces;

public interface IRecordSearch {
    boolean isEmpty();

    default boolean isAnyFieldFilled() {
        return !isEmpty();
    }
}
