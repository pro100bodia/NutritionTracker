package com.bod.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {
    public static final String ROLE_DOCTOR = "DOCTOR";
    public static final String ROLE_CLIENT = "CLIENT";

    private static final Map<String, String> mapConfig = new HashMap<String, String>();

    static {
        init();
    }

    private static void init() {
        mapConfig.put("client", "/client_page");
        mapConfig.put("doctor", "/doctor_page");
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static String getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
