package com.bod.command;

import com.bod.dto.ClientDTO;
import com.bod.facade.ClientFacade;

import javax.servlet.http.HttpServletRequest;

public class GenerateClientData implements Command {
    @Override
    public String execute(HttpServletRequest req, int id) {
        ClientFacade clientFacade = new ClientFacade();

        ClientDTO client = clientFacade.getData(id);

        req.setAttribute("image", client.getImg());
        req.setAttribute("name", client.getName());
        req.setAttribute("age", client.getAge());
        req.setAttribute("gender", client.getGender());
        req.setAttribute("height", client.getHeight());
        req.setAttribute("weight", client.getWeight());
        req.setAttribute("lifeStyle", client.getLifeStyle());

        //todo change according to role
        return "jsp/client_page.jsp";
    }
}
