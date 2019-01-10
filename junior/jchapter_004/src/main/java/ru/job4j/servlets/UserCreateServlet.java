package ru.job4j.servlets;

import ru.job4j.logic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserCreateServlet extends HttpServlet {
    private final ValidateService storage = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/create.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            storage.add(
                    new User(
                            req.getParameter("name"),
                            req.getParameter("login"),
                            req.getParameter("email")
                    )
            );
            resp.sendRedirect("/");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
