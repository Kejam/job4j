package ru.job4j.carStrorage.Presentation;

import ru.job4j.carStrorage.Car.Storage;
import ru.job4j.carStrorage.CarStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CarStorageServlet extends HttpServlet {
    private final Storage storage = CarStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars", storage.returnAll());
        req.getRequestDispatcher("WEB-INF/views/cars.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action").equals("true")) {
            storage.add(
                    req.getParameter("name"),
                    Integer.valueOf(req.getParameter("engine")),
                    Integer.valueOf(req.getParameter("carBody")),
                    Integer.valueOf(req.getParameter("transmission"))
            );
        }
        resp.sendRedirect(String.format("%s/cars",  req.getContextPath()));
    }
}
