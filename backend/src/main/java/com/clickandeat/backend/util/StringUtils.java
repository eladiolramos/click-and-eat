package com.clickandeat.backend.util;

public final class StringUtils {

    // Método para poner la primera letra en mayúscula
    public static String capitalize(String name) {

        if (name == null || name.isBlank()) {
            return name;
        }

        String cleanName = name.trim();

        return cleanName.substring(0, 1).toUpperCase() + cleanName.substring(1).toLowerCase();
    }
}
