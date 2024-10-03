package edu.kirkwood.java2ee_demo;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static edu.kirkwood.shared.Helpers.round;
import static edu.kirkwood.shared.Validators.isANumber;

public class TempConverter extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("temp-converter.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String temp = req.getParameter("temp");
        String offset = "32";
        String factor = "5";
        String factor2 = "9";

        req.setAttribute("temp",temp);
        boolean errorFound = false;
        if(!isANumber(temp)){
            req.setAttribute("tempError", "Invalid temperature");
            errorFound = true;
        }
        if(errorFound){
            req.getRequestDispatcher("temp-converter.jsp").forward(req, resp);
            return;
        }
        if (!isANumber(temp) || Double.parseDouble(temp) <= -459.67) {
            req.setAttribute("tempError", "Invalid temperature. Must be a number greater than -459.67°F.");
            errorFound = true;

        }
        if(errorFound){
            req.getRequestDispatcher("temp-converter.jsp").forward(req, resp);
            return;
        }

        double celsius = getCelsius(temp,offset,factor,factor2);
        req.setAttribute("result",String.format("(%s - %s) x %s/%s = %S ",temp+"\u00B0F",offset,factor,factor2,round(celsius,1)+"\u00B0C "));
        req.getRequestDispatcher("temp-converter.jsp").forward(req, resp);


    }
    private static double getCelsius(String temp, String offset, String factor, String factor2){
        double f = Double.parseDouble(temp);
        double o = Double.parseDouble(offset);
        double f1 = Double.parseDouble(factor);
        double f2 = Double.parseDouble(factor2);
        return (f - o) * f1 / f2;




    }
}
