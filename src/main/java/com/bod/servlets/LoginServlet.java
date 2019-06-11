package com.bod.servlets;

import com.bod.entity.Client;
import com.bod.entity.Role;
import com.bod.services.ClientService;
import com.bod.utils.AppUtils;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static Logger LOG = Logger.getLogger("LoginServlet");
    private RequestDispatcher loginDispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("error_message", "error.login.empty");
        LOG.debug("Login error message is empty");
        loginDispatcher = req.getRequestDispatcher("jsp/login.jsp");
        loginDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginDispatcher = req.getRequestDispatcher("/jsp/login.jsp");
        String userName = req.getParameter("userName").trim();
        String password = req.getParameter("password").trim();

        //get client from database
        Client loginedClient = new ClientService().getLoginData(userName, password);
        //if not found forward error message
        if (loginedClient == null) {
            LOG.error("Client not found in the database");

            req.setAttribute("error_message", "error.login.message");
            LOG.debug("Login error message returned");
            loginDispatcher.forward(req, resp);
            return;
        }
        LOG.info("Got client from database: " + loginedClient.getName());

        //store data in the session
        AppUtils.storeClientInSession(req, loginedClient);

        //do redirect
        String redirectTo;

        Role role = loginedClient.getRole();
        if (role.name().equals("C")) {
            redirectTo = "/nutrition_tracker/client_page";
            LOG.info("Client redirected to client_page");
        } else {
            redirectTo = "/nutrition_tracker/doctor_page";
            LOG.info("Client redirected doctor_page");
        }
        resp.sendRedirect(redirectTo);
    }
}
