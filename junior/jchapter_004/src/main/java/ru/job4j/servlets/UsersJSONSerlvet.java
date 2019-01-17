package ru.job4j.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.logic.Man;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;

public class UsersJSONSerlvet extends HttpServlet {
    ConcurrentHashMap<String, Man> users = new ConcurrentHashMap<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,/json");
        String json = new ObjectMapper().writeValueAsString(users);
        PrintWriter writer = resp.getWriter();
        writer.append(json);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String sex = req.getParameter("sex");
        String description = req.getParameter("description");
        users.put(id, new Man(
                id, name, surname, sex, description
                )
        );
    }
}
