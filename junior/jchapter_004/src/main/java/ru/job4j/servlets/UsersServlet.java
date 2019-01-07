package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UsersServlet extends HttpServlet {
    private final ValidateService storage = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        writer.append("<html>");
        writer.append("<body>List users</body>");
        writer.append("<body>");
        this.storage
                .findAll()
                .forEach(writer::println);
        writer.append("</body>");
        writer.append("</html>");
        writer.flush();
    }
}
