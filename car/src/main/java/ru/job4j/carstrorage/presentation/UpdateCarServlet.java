package ru.job4j.carstrorage.presentation;

import ru.job4j.carstrorage.logic.AdStorage;
import ru.job4j.carstrorage.logic.items.Ad;
import ru.job4j.carstrorage.logic.items.Car;
import ru.job4j.carstrorage.logic.items.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            User user = (User) req.getSession().getAttribute("user");
            boolean status = false;
            if (req.getParameter("status").equals("false")) {
                status = false;
            }
            Car car = new Car();
            Ad ad = new Ad();
            ad.setUser(user);
            ad.setCar(car);
            storage.update(ad);
            resp.sendRedirect(String.format("%s/list", req.getContextPath()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
