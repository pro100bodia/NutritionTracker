package com.bod.command;

import com.bod.entity.Client;
import com.bod.services.ClientService;
import com.bod.utils.AppUtils;

import javax.servlet.http.HttpServletRequest;

public class DoctorCommand implements Command {
    /**
     * Command designed to get information about the doctor
     */

    /**
     * Get doctors further information by id
     *
     * @param req request containing doctor`s id
     * @return doctor page url
     */
    @Override
    public String execute(HttpServletRequest req) {
        Client client = AppUtils.getClientFromSession(req);

        client.setName(new ClientService().getName(client.getId()));

        req.setAttribute("client_name", client.getName());

        return "jsp/doctor_page.jsp";
    }
}
