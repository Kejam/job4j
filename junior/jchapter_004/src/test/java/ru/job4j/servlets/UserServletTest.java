package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import ru.job4j.logic.User;
import ru.job4j.other.UserServlet;
import ru.job4j.validate.Validate;
import ru.job4j.validate.ValidateService;
import ru.job4j.validate.ValidateStub;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)

public class UserServletTest {

    @Test
    public void whenAddUserThenStoreIt() throws ServletException, IOException {
        ValidateService validate = mock(ValidateService.class);
        Whitebox.setInternalState(ValidateService.class, "INSTANCE", validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("action")).thenReturn("update");
        when(req.getParameter("id")).thenReturn("1");
        when(req.getParameter("name")).thenReturn("Petr Arsentev");
        when(req.getParameter("login")).thenReturn("parsentev");
        when(req.getParameter("email")).thenReturn("parsentev@yandex.ru");
        when(resp.getOutputStream()).thenReturn(mock(ServletOutputStream.class));
        new UserServlet().doPost(req, resp);
        verify(validate).update(1, new User("Petr Arsentev", "parsentev", "parsentev@yandex.ru"));
    }

    @Test
    public void whenDeleteUser() throws ServletException, IOException {
        ValidateService validate = mock(ValidateService.class);
        Whitebox.setInternalState(ValidateService.class, "INSTANCE", validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("action")).thenReturn("delete");
        when(req.getParameter("id")).thenReturn("1");
        when(resp.getOutputStream()).thenReturn(mock(ServletOutputStream.class));
        new UserServlet().doPost(req, resp);
        verify(validate).delete(1);
    }
}