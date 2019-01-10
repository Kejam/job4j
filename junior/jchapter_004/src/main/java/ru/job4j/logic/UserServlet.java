package ru.job4j.logic;

import ru.job4j.logic.User;
import ru.job4j.servlets.CRUD;
import ru.job4j.servlets.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UserServlet extends HttpServlet {
    private final ValidateService storage = ValidateService.getInstance();
    private final Map<CRUD, Function<HttpServletRequest, Boolean>> dispatcher = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        this.dispatcher.put(
                CRUD.ADD,
                request -> storage.add(
                        new User(
                                request.getParameter("name"),
                                request.getParameter("login"),
                                request.getParameter("email")
                        )
                )
        );
        this.dispatcher.put(
                CRUD.UPDATE,
                request -> storage.update(
                        Integer.parseInt(request.getParameter("id")),
                        new User(
                                request.getParameter("name"),
                                request.getParameter("email"),
                                request.getParameter("login")
                        )
                )
        );
        this.dispatcher.put(
                CRUD.DELETE,
                request -> storage.delete(
                        Integer.parseInt(request.getParameter("id"))
                )
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        this.storage
                .findAll()
                .forEach(writer::println);
        writer.flush();
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
    // http://localhost:8080/jchapter_004_war_exploded/users?action=add&id=1&name=alex&login=kejam&email=kj@mail.ru
}
