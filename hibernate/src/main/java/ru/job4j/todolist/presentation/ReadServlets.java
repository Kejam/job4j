package ru.job4j.todolist.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.todolist.logic.model.Item;
import ru.job4j.todolist.validate.Validate;
import ru.job4j.todolist.validate.ValidateStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class ReadServlets extends HttpServlet {
    private final Validate storage = ValidateStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = new ObjectMapper().writeValueAsString(storage.readAll());
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        storage.add(new Item(
                description, new Timestamp(System.currentTimeMillis()), false
        ));
    }
}
