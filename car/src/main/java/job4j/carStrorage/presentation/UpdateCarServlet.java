package job4j.carStrorage.presentation;

import job4j.carStrorage.logic.AdStorage;
import job4j.carStrorage.logic.items.Ad;
import job4j.carStrorage.logic.items.Car;
import job4j.carStrorage.logic.items.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

public class UpdateCarServlet extends HttpServlet {
    private final AdStorage storage = AdStorage.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", req.getParameter("id"));
        req.getRequestDispatcher("WEB-INF/views/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = storage.findUserByLogin(req.getParameter("login"));
            boolean status = false;
            if (req.getParameter("status").equals("false")) {
                status = false;
            }
            Car car = new Car(
                    req.getParameter("namecar"),
                    req.getParameter("engine"),
                    req.getParameter("carBody"),
                    req.getParameter("transmission"),
                    req.getParameter("color")
            );
            storage.update(
                    new Ad(
                            Integer.valueOf(req.getParameter("id")),
                            req.getParameter("name"),
                            user,
                            req.getParameter("descrition"),
                            Integer.valueOf(req.getParameter("sale")),
                            status,
                            car
                    )
            );
            resp.sendRedirect(String.format("%s/list", req.getContextPath()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
