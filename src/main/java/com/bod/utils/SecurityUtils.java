package com.bod.utils;

import com.bod.entity.Client;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class SecurityUtils {
    public static boolean isSecurityPage(HttpServletRequest request) {
        String urlPattern = UrlPatternUtils.getUrlPattern(request);

        Set<String> roles = SecurityConfig.getAllAppRoles();

        for (String role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPermission(HttpServletRequest req) {
        String urlPattern = UrlPatternUtils.getUrlPattern(req);

        Client client = AppUtils.getClientFromSession(req);
        String role = client.getRole().name();

        List<String> patternsList = SecurityConfig.getUrlPatternsForRole(role);
        for (String roleUrlPattern : patternsList) {
            if (roleUrlPattern.equals(urlPattern)) {
                return true;
            }
        }
        return false;
    }
}
