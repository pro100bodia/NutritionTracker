package com.bod.utils;

import java.util.*;

public class SecurityConfig {
    public static final String ROLE_DOCTOR = "DOCTOR";
    public static final String ROLE_CLIENT = "CLIENT";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {
        mapConfig.put("client", Arrays.asList("/client_page"));
        mapConfig.put("doctor", Arrays.asList("/doctor_page", "/client_page"));
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
