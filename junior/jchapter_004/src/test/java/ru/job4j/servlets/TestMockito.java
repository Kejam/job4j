package ru.job4j.servlets;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.other.UserServlet;
import ru.job4j.validate.Validate;
import ru.job4j.validate.ValidateService;
import ru.job4j.validate.ValidateStub;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class TestMockito {


    @Ignore
    @Test
    public void whenAddUserThenStoreIt() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        Mockito.when(ValidateService.getInstance()).thenReturn((ValidateService) validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("name")).thenReturn("Petr Arsentev");
        new UserServlet().doPost(req, resp);
        assertThat(validate.findAll().iterator().next().getName(), is("Petr Arsentev"));
    }
}
