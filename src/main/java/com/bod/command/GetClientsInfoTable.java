package com.bod.command;

import com.bod.dto.ClientStatisticsDTO;
import com.bod.facade.ClientFacade;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetClientsInfoTable implements Command {
    /**
     * @param req
     * @return
     */
    @Override
    public String execute(HttpServletRequest req) {
        ClientFacade clientFacade = new ClientFacade();

        List<ClientStatisticsDTO> clientStat = clientFacade.getClientStatistics();

        int page = 1;
        String pageStr;
        if ((pageStr = req.getParameter("page")) != null) {
            page = Integer.parseInt(pageStr);
        }

        int fromIndex = (page - 1) * 5;
        int toIndex = fromIndex + 4;
        req.setAttribute("clientStat", clientStat.subList(fromIndex, toIndex));

        List<Integer> links = IntStream.rangeClosed(1, clientStat.size() / 5)
                .boxed().collect(Collectors.toList());
        req.setAttribute("links", links);


        return "jsp/doctor_page.jsp";
    }
}
