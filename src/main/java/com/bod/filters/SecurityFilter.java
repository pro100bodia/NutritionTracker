package com.bod.filters;

import com.bod.entity.Client;
import com.bod.utils.AppUtils;
import com.bod.utils.SecurityUtils;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {
    private static Logger LOG = Logger.getLogger(SecurityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (SecurityUtils.isSecurityPage(req)) {
            LOG.info("Loading security page");

            Client client;
            try {
                client = AppUtils.getClientFromSession(req);
            } catch (NullPointerException e) {
                client = null;
            }

            if (client != null) {
                boolean hasPermission = SecurityUtils.hasPermission(req);
                if (!hasPermission) {
                    throwAccessDeniedError(resp);
                } else {
                    continueProcessing(req, resp, filterChain);
                }
            } else {
                throwAccessDeniedError(resp);
            }
        } else {
            continueProcessing(req, resp, filterChain);
        }

    }

    @Override
    public void destroy() {

    }

    private void throwAccessDeniedError(HttpServletResponse resp) throws ServletException, IOException {
        LOG.error("Access denied");
        resp.sendError(403);
    }

    private void continueProcessing(HttpServletRequest req,
                                    HttpServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        LOG.info("Passing the request");
        filterChain.doFilter(req, resp);
    }
}
