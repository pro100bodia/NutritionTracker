package com.bod.command;

import com.bod.dto.ClientDTO;
import com.bod.facade.ClientFacade;
import com.bod.utils.AppUtils;

import javax.servlet.http.HttpServletRequest;

public class GenerateClientData implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        ClientFacade clientFacade = new ClientFacade();
        int id = AppUtils.getClientFromSession(req).getId();

        ClientDTO client = clientFacade.getData(id);

        req.getServletContext().setAttribute("id", id);
        req.getServletContext().setAttribute("image", client.getImg());
        req.getServletContext().setAttribute("name", client.getName());
        req.getServletContext().setAttribute("age", client.getAge());
        req.getServletContext().setAttribute("gender", client.getGender());
        req.getServletContext().setAttribute("height", client.getHeight());
        req.getServletContext().setAttribute("weight", client.getWeight());
        req.getServletContext().setAttribute("lifeStyle", client.getLifeStyle());

        //todo change according to role
        return "jsp/client_page.jsp";
    }
}
