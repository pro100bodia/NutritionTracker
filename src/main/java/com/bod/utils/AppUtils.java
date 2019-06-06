package com.bod.utils;

import com.bod.entity.Client;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AppUtils {
    private static Logger LOG = Logger.getLogger(AppUtils.class);

    public static void storeClientInSession(HttpServletRequest req, Client client) {
        HttpSession session = req.getSession();
        session.setAttribute("client", client);

        LOG.debug("Client " + client.getName() + "is set to the session");
    }

    public static Client getClientFromSession(HttpServletRequest req) {
        return (Client) req.getSession().getAttribute("client");
    }
}
