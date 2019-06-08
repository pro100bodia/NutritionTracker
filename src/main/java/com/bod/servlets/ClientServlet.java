package com.bod.servlets;

import com.bod.command.Command;
import com.bod.command.GenerateClientData;
import com.bod.entity.Client;
import com.bod.utils.AppUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ClientServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = AppUtils.getClientFromSession(req);
        int clientId = client.getId();
        LOG.debug("Client id: " + clientId);

        Command command = new GenerateClientData();
        String url = command.execute(req, clientId);

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
