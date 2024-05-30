package com.jotasantos.app.diariooficial.utils;

public class UtilsValidators {

    public UtilsValidators() {
    }

    public static boolean stringIsNullOrEmpty(String str) {
        return str == null || str.isBlank();
    }

    public static boolean integerIsNullOrZero(Integer number) {
        return number == null || number == 0;
    }

    public static boolean longIsNullOrZero(Long number) {
        return number == null || number == 0;
    }
}
