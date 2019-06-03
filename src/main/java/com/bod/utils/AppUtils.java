package com.bod.utils;

import com.bod.entity.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AppUtils {
    public static void storeClientInSession(HttpServletRequest req, Client client) {
        HttpSession session = req.getSession();

        session.setAttribute("client", client);
    }

    public static Client getClientFromSession(HttpServletRequest req) {
        return (Client) req.getSession().getAttribute("client");
    }
}
