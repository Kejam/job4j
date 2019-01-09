package ru.job4j.servlets;

import ru.job4j.logic.User;

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
        writer.append("<table>");
        for (User user: this.storage.findAll()) {
            writer.append("<tr>");
            writer.append("<td>");
            writer.append(user.getName());
            writer.append("</td>");
            writer.append("<td>");
            writer.append(user.getID());
            writer.append("</td>");
            writer.append("<td>");
            writer.append(user.getEmail());
            writer.append("</td>");
            writer.append("<td>");
            writer.append(user.getLogin());
            writer.append("</td>");
            writer.append("<td>");
            writer.append(user.getDate());
            writer.append("</td>");
            writer.append("<td>");
            writer.append("<form action=\"" + req.getContextPath() + "\"/UserCreateServlet\" method=\"post\">");
            writer.append("<input type=\"hidden\" name=\"create\" value=\"\">");
            writer.append("</form>");
            writer.append("</td>");
            writer.append("<td>");
            writer.append("<form action=\"" + req.getContextPath() + "\"/UserUpdateServlet\" method=\"post\">");
            writer.append("<input type=\"hidden\" name=\"id\" value=\"<%=id%" + user.getId() + ">\"/>");
            writer.append("</form>");
            writer.append("</td>");
            writer.append("</tr>");
        }
        writer.append("</table>");
        writer.append("</body>");
        writer.append("</html>");
        writer.flush();
    }
}
