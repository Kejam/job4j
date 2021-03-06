package ru.job4j.servlets;

import ru.job4j.validate.Validate;
import ru.job4j.validate.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {
    private final Validate storage = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        storage.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(String.format("%s/",  req.getContextPath()));
    }
}
