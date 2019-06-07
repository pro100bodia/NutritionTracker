package com.bod.utils;

import java.util.*;

public class SecurityConfig {
    private static final String ROLE_DOCTOR = "D";
    private static final String ROLE_CLIENT = "C";

    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        mapConfig.put(ROLE_CLIENT, Arrays.asList("/client_page"));
        mapConfig.put(ROLE_DOCTOR, Arrays.asList("/doctor_page", "/client_page"));
    }

    static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
