package com.bod.servlets;

import com.bod.entity.Client;
import com.bod.entity.Role;
import com.bod.services.ClientService;
import com.bod.utils.AppUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private RequestDispatcher loginDispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginDispatcher = req.getRequestDispatcher("jsp/login.jsp");
        loginDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        //get client from database
        Client loginedClient = new ClientService().getLoginData(userName, password);

        //if not found forward error message
        if (loginedClient == null) {
            req.setAttribute("error.message", "User not found");
            loginDispatcher.forward(req, resp);
        }else{

        }

        //store data in the session
        AppUtils.storeClientInSession(req, loginedClient);

        //do redirect
        RequestDispatcher pageDispathcer;

        Role role = loginedClient.getRole();
        if (role.name().equals("C")) {
            pageDispathcer = req.getRequestDispatcher("jsp/client_page.jsp");
        } else {
            pageDispathcer = req.getRequestDispatcher("jsp/doctor_page.jsp");
        }
        pageDispathcer.forward(req, resp);
    }
}
