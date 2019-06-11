package com.bod.servlets;

import com.bod.command.Command;
import com.bod.command.FillPlate;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PlateServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(PlateServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command plateCommand = new FillPlate();

        String result = plateCommand.execute(req);

        resp.setContentType("text/html");
        resp.getWriter().write(result);
    }
}
