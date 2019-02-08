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
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

public class CreateCarServlet extends HttpServlet {
    private final AdStorage storage = AdStorage.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = storage.findUserByLogin(req.getParameter("login"));
            Boolean status = false;
            Car car = new Car();
            Ad ad = new Ad();
            storage.add(ad);
            resp.sendRedirect(String.format("%s/list", req.getContextPath()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
