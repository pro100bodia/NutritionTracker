package com.bod.filters;

import com.bod.entity.Client;
import com.bod.utils.AppUtils;
import com.bod.utils.SecurityUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Client loginedUser = AppUtils.getClientFromSession(req);

//        String servletPath = req.getServletPath();

//        if (servletPath.equals("/login")) {
//            filterChain.doFilter(req, resp);
//            return;
//        }

        if (loginedUser != null) {
//            String userName = loginedUser.getName();
            String userRole = loginedUser.getRole().name();

        }

        if (SecurityUtils.isSecurityPage(req)) {
            boolean hasPermission = SecurityUtils.hasPermission(req);
            if (!hasPermission) {
                RequestDispatcher dispatcher
                        = req.getServletContext().getRequestDispatcher("/jsp/errors/403.jsp");

                dispatcher.forward(req, resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
