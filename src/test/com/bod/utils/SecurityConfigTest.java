package com.bod.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SecurityConfigTest {
    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    @Before
    public void setUp() {
        mapConfig.put("C", Arrays.asList("/client_page"));
        mapConfig.put("D", Arrays.asList("/doctor_page", "/client_page"));
    }

    @Test
    public void shouldReturnAllAppRoles() {
        Set<String> rolesSet = new HashSet<>();
        rolesSet.add("D");
        rolesSet.add("C");
        assertEquals(rolesSet, SecurityConfig.getAllAppRoles());
    }

    @Test
    public void getUrlPatternsForRole() {
        List<String> urlPatterns = Arrays.asList("/doctor_page", "/client_page");
        assertEquals(urlPatterns, SecurityConfig.getUrlPatternsForRole("D"));
    }
}