package job4j.carStrorage.presentation;

import job4j.carStrorage.logic.AdStorage;
import job4j.carStrorage.logic.interfaces.StorageAd;
import job4j.carStrorage.logic.items.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private final AdStorage storage = AdStorage.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/signin.jsp").forward(req, resp);
        if (req.getParameter("quest").equals("true")) {
            HttpSession session = req.getSession();
            session.setAttribute("login", "quest");
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (storage.findByLogin(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "error sign in");
            doGet(req, resp);
        }
    }
}
