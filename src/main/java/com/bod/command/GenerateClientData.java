package com.bod.command;

import com.bod.dto.ClientDTO;
import com.bod.facade.ClientFacade;

import javax.servlet.http.HttpServletRequest;

public class GenerateClientData implements Command {
    int id;

    public GenerateClientData(int id) {
        this.id = id;
    }

    @Override
    public String execute(HttpServletRequest req) {
        ClientFacade clientFacade = new ClientFacade(id);

        ClientDTO client = clientFacade.getData();

        req.setAttribute("image", client.getImg());
        req.setAttribute("name", client.getName());
        req.setAttribute("age", client.getAge());
        req.setAttribute("gender", client.getGender());
        req.setAttribute("height", client.getHeight());
        req.setAttribute("weight", client.getWeight());
        req.setAttribute("lifeStyle", client.getLifeStyle());

        return "jsp/client_page.jsp";
    }
}
