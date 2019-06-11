package com.bod.utils;

import java.util.*;

class SecurityConfig {
    private static final String ROLE_DOCTOR = "D";
    private static final String ROLE_CLIENT = "C";

    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        mapConfig.put(ROLE_CLIENT, Arrays.asList("/client_page", "/custom_food", "/concrete_day_plate"));
        mapConfig.put(ROLE_DOCTOR, Arrays.asList("/doctor_page", "/client_page", "/custom_food", "/concrete_day_plate"));
    }

    static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
