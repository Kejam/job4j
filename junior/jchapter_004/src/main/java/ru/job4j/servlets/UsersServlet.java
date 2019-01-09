package ru.job4j.servlets;

import ru.job4j.logic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UsersServlet extends HttpServlet {
    private final Map<CRUD, Function<HttpServletRequest, Boolean>> dispatcher = new HashMap<>();
    private final ValidateService storage = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        final String action = req.getParameter("action").toUpperCase();
        for (CRUD predict: this.dispatcher.keySet()) {
            if (predict.equals(action)) {
                dispatcher.get(predict);
            }
        }
        writer.flush();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        this.dispatcher.put(
                CRUD.UPDATE,
                request -> df
        this.dispatcher.put(
                CRUD.DELETE,
                request -> storage.delete(Integer.parseInt(request.getParameter("id")))
        );
    }
}
