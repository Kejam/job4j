package ru.job4j.servlets;

import ru.job4j.other.CRUD;
import ru.job4j.validate.Validate;
import ru.job4j.validate.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UsersServlet extends HttpServlet {
    private final Map<CRUD, Function<HttpServletRequest, Boolean>> dispatcher = new HashMap<>();
    private final Validate storage = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("Users", storage.findAll());
        req.getRequestDispatcher("WEB-INF/views/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(String.format("%s/",  req.getContextPath()));
    }

    @Override
    public void init() throws ServletException {
        super.init();
        this.dispatcher.put(
                CRUD.DELETE,
                request -> storage.delete(Integer.parseInt(request.getParameter("id")))
        );
    }
}
