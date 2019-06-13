package com.bod.servlets;

import com.bod.command.Command;
import com.bod.command.DoctorCommand;
import com.bod.command.GetClientsInfoTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoctorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command doctorCommand = new DoctorCommand();
        String url = doctorCommand.execute(req);

        //get clients info table
        doctorCommand = new GetClientsInfoTable();
        doctorCommand.execute(req);

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
