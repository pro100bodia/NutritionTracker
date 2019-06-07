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

        String servletPath = req.getServletPath();
        System.out.println(servletPath);

        if (servletPath.equals("/login") || servletPath.equals("/index.jsp")) {
            filterChain.doFilter(req, resp);
            return;
        }

        if (loginedUser != null) {
//            String userName = loginedUser.getName();
            String userRole = loginedUser.getRole().name();

        }

        if (SecurityUtils.isSecurityPage(req)) {
            boolean hasPermission = SecurityUtils.hasPermission(req);
            if (!hasPermission) {
//                RequestDispatcher dispatcher
//                        = req.getServletContext().getRequestDispatcher("/nutrition_tracker/jsp/errors/403.jsp");

//                dispatcher.forward(req, resp);
                resp.setStatus(403);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
