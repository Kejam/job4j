package ru.job4j.servlets;

import ru.job4j.logic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserCreateServlet extends HttpServlet {
    private final ValidateService storage = ValidateService.getInstance();
    private String getHtml(String message, String method, String form) {
        return "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Create User</title>"
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
        var html = this.getHtml(
                "",
                "<form action='" + req.getContextPath() + "/create' method='post'>"
                        + "Name : <input type='text' name='name'/>"
                        + "Login : <input type='text' name='login'/>"
                        + "Email : <input type='text' name='email'/>"
                        + "<input type='submit' value='create'>"
                        + "</form>",
                ""
        );
        writer.append(html);
        writer.flush();
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
            resp.sendRedirect("/list");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
