package com.bod.command;

import com.bod.dto.ClientDTO;
import com.bod.facade.ClientFacade;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UpdateClientData implements Command {
    /**
     * Command that executes when client sends request
     * for his personal data update
     */
    private static final Logger LOG = Logger.getLogger(UpdateClientData.class);

    /**
     * Collects data from input fields and send to database
     *
     * @param req request that contains parameters to change
     * @return link to redirect after personal data update
     */
    @Override
    public String execute(HttpServletRequest req) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(Integer.parseInt(req.getParameter("id")));
        clientDTO.setName(req.getParameter("name").trim());

        LOG.info("updating information for: " + clientDTO.getName());

        clientDTO.setGender(req.getParameter("gender").trim());
        clientDTO.setHeight(Double.parseDouble(req.getParameter("height").trim()));
        clientDTO.setWeight(Double.parseDouble(req.getParameter("weight").trim()));
        clientDTO.setLifeStyle(req.getParameter("lifeStyle").trim());

        ClientFacade updateFacade = new ClientFacade();
        updateFacade.updateClientData(clientDTO);

        return "jsp/client_page.jsp";
    }
}
