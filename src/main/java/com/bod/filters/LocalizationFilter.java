package com.bod.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocalizationFilter implements Filter {
    private static final String BUNDLE = "bundle";
    private static final String LOCALE = "locale";
    private static String defaultBundle;
    private static String defaultLocale;
    private static Logger LOG = Logger.getLogger(LocalizationFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        defaultBundle = filterConfig.getInitParameter(BUNDLE);
        defaultLocale = filterConfig.getInitParameter(LOCALE);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Cookie[] cookie = req.getCookies();

        String locale = null, cookieName;
        for(Cookie ck: cookie){
            cookieName = ck.getName();
            if(cookieName.equals(LOCALE))
            locale = ck.getValue();
        }

        LOG.info("Locale choose to " + locale);

        //fixme create cookie if abscent
        if (locale == null)
            locale = defaultLocale;

        servletRequest.setAttribute(LOCALE, locale);
        servletRequest.setAttribute(BUNDLE, defaultBundle);

        LOG.info("Locale set to " + locale);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
