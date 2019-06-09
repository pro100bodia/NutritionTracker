package com.bod.servlets;

import com.bod.command.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ClientServlet.class);
    private Command command;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        command = new GenerateClientData();
        String url = command.execute(req);

        command = new GetFoodList();
        command.execute(req);

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        command = new UpdateClientData();
        String url = command.execute(req);

        command = new FillPlate();
        command.execute(req);

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
