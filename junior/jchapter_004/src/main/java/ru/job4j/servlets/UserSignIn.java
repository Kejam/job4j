package ru.job4j.servlets;

import ru.job4j.logic.DBStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserSignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (DBStore.getInstance().isCredential(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("role", DBStore.getInstance().role(login, password));
            resp.sendRedirect("/");
        } else {
            req.setAttribute("error", "error sign in");
            doGet(req, resp);
        }
    }
}
