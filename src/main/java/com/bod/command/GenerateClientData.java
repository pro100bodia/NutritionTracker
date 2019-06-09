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

        req.setAttribute("id", id);
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
