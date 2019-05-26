package com.bod.servlets;

import com.bod.command.Command;
import com.bod.command.GenerateClientData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int clientId = (Integer) req.getAttribute("client_id");

        Command command = new GenerateClientData(clientId);
        String url = command.execute(req);

        req.getRequestDispatcher(url).include(req, resp);
    }
}
