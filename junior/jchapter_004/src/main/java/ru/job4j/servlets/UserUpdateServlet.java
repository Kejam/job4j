package ru.job4j.servlets;

import ru.job4j.logic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateServlet extends HttpServlet {
    private final ValidateService storage = ValidateService.getInstance();
    private String getHtml(String message, String method, String form) {
        return "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Update User</title>"
                + "</head>"
                + "<body>"
                + message
                + method
                + form
                + "</body>"
                + "</html>";
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        int id = Integer.parseInt(req.getParameter("id"));
        User user = storage.findById(id);
        if (user == null) {
            var html = this.getHtml("","Users not found","");
        }
        var html = this.getHtml(
                "",
                "<form action='" + req.getContextPath() + "/update' method='post'>"
                        + "Name : <input type='text' value='" + user.getName() + "' name='name'/>"
                        + "<input type='submit' value='update'>"
                        + "</form>",
                ""
        );
        writer.append(html);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            storage.update(
                    Integer.parseInt(req.getParameter("id")),
                    req.getParameter("name")
            );
            resp.sendRedirect("/list");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
