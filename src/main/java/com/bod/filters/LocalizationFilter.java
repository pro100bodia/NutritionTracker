package com.bod.filters;

import javax.servlet.*;
import java.io.IOException;

public class LocalizationFilter implements Filter {
    private static final String BUNDLE = "bundle";
    private static final String LOCALE = "locale";
    private String bundle;
    private String locale;
    private String defaultLocale;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        bundle = filterConfig.getInitParameter(BUNDLE);
        defaultLocale = filterConfig.getInitParameter(LOCALE);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        locale = (String) servletRequest.getAttribute(LOCALE);

        if (locale == null)
            locale = defaultLocale;

        servletRequest.setAttribute(LOCALE, locale);
        servletRequest.setAttribute(BUNDLE, bundle);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
