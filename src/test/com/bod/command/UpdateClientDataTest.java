package com.bod.command;

import com.bod.dto.ClientDTO;
import com.bod.facade.ClientFacade;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;

public class UpdateClientDataTest {

    private HttpServletRequest req;
    private ClientFacade updateFacade;
    private ClientDTO clientDTO;
    private UpdateClientData updateClientData;

    @Test
    public void shouldExecute() {
        updateClientData = new UpdateClientData();
        req = mock(HttpServletRequest.class);
        clientDTO = mock(ClientDTO.class);
        updateFacade = mock(ClientFacade.class);

        when(req.getParameter("id")).thenReturn("8");
        when(req.getParameter("name")).thenReturn("Boris");
        when(req.getParameter("gender")).thenReturn("female");
        when(req.getParameter("height")).thenReturn("123.3");
        when(req.getParameter("weight")).thenReturn("23.3");
        when(req.getParameter("lifestyle")).thenReturn("Lite");

        updateClientData.execute(req);

        verify(req).getParameter("id");
        verify(req).getParameter("name");
        verify(req).getParameter("gender");
        verify(req).getParameter("height");
        verify(req).getParameter("weight");
        verify(req).getParameter("lifestyle");
    }
}