package edu.kirkwood.java2ee_demo;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static edu.kirkwood.shared.Helpers.round;
import static edu.kirkwood.shared.Validators.isANumber;
@WebServlet(value= "/MeterToFoot")
public class MeterToFoot extends HttpServlet{
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("MeterToFoot.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String meters = req.getParameter("meters");


        req.setAttribute("meters", meters);
        boolean errorFound = false;
        if(!isANumber(meters)){
            req.setAttribute("metersError", "Invalid meters");
            errorFound = true;
        }
        if (!isANumber(meters) || Double.parseDouble(meters) <0){
            req.setAttribute("metersError", "Invalid meters. Must be a positive number.");
            errorFound = true;
        }
        if(errorFound){
            req.getRequestDispatcher("MeterToFoot.jsp").forward(req, resp);
            return;
        }

        double foot = getFoot(meters);
        req.setAttribute("result",String.format("%s Meter = %s Feet" ,meters,round(foot,1)));
        req.getRequestDispatcher("MeterToFoot.jsp").forward(req, resp);

    }
    private static double getFoot(String meters){
        double m = Double.parseDouble(meters);
        return m * 3.28084;


    }
}
