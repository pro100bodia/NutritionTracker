package com.bod.servlets;

import com.bod.command.Command;
import com.bod.command.NormCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command normCommand = new NormCommand();
        String result = normCommand.execute(req);

        resp.setContentType("text/html");
        resp.getWriter().write(result);
    }
}
