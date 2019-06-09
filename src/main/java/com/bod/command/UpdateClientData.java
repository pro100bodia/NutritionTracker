package com.bod.command;

import com.bod.dto.ClientDTO;
import com.bod.facade.ClientFacade;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UpdateClientData implements Command {
    private static final Logger LOG = Logger.getLogger(UpdateClientData.class);

    @Override
    public String execute(HttpServletRequest req) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(Integer.parseInt(req.getParameter("id")));
        clientDTO.setName(req.getParameter("name"));

        LOG.info("updating information for: " + clientDTO.getName());

        clientDTO.setGender(req.getParameter("gender"));
        clientDTO.setHeight(Double.parseDouble(req.getParameter("height")));
        clientDTO.setWeight(Double.parseDouble(req.getParameter("weight")));
        clientDTO.setLifeStyle(req.getParameter("lifeStyle"));

        ClientFacade updateFacade = new ClientFacade();
        updateFacade.updateClientData(clientDTO);

        return "jsp/client_page.jsp";
    }
}
