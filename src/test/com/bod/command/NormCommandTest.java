package com.bod.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.mock;

public class NormCommandTest {
    HttpServletRequest req = mock(HttpServletRequest.class);
    HttpSession session = mock(HttpSession.class);

    when(req.getSession()).

    thanReturn(session);


}