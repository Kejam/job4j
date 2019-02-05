package job4j.carStrorage.presentation;

import job4j.carStrorage.logic.AdStorage;
import job4j.carStrorage.logic.items.Ad;
import job4j.carStrorage.logic.items.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewCarServlet extends HttpServlet {
    private final AdStorage storage = AdStorage.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ad ad = storage.returnById(Integer.parseInt(req.getParameter("id")));
        Car car = ad.getCar();
        req.setAttribute("ad", ad);
        req.setAttribute("car", car);
        req.getRequestDispatcher("WEB-INF/views/viewcar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(String.format("%s/list",  req.getContextPath()));
    }
}