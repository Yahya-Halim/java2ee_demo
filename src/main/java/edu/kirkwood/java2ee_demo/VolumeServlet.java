package edu.kirkwood.java2ee_demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/volume")
public class VolumeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("volume.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String radiusStr = req.getParameter("radius");
        String heightStr = req.getParameter("height");

        req.setAttribute("radius", radiusStr);
        req.setAttribute("height", heightStr);

        String error = "";

        double radius = 0;
        double height = 0;

        try {
            radius = Double.parseDouble(radiusStr);
            if (radius < 0) {
                error += "<li>Radius cannot be negative.</li>";
            }
        } catch (NumberFormatException e) {
            error += "<li>Radius must be a valid number.</li>";
        }

        // Validate height
        try {
            height = Double.parseDouble(heightStr);
            if (height < 0) {
                error += "<li>Height cannot be negative.</li>";
            }
        } catch (NumberFormatException e) {
            error += "<li>Height must be a valid number.</li>";
        }

        if (!error.isEmpty()) {
            req.setAttribute("error", "<ul>" + error + "</ul>");
            req.getRequestDispatcher("volume.jsp").forward(req, resp);
            return;
        }

        Cylinder cylinder = new Cylinder(radius, height);
        String result = cylinder.toString();

        req.setAttribute("result", result);
        req.getRequestDispatcher("volume.jsp").forward(req, resp);
    }
}
