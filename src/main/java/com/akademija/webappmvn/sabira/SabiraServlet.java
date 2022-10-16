package com.akademija.webappmvn.sabira;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SabiraServlet", value = "/sabira")
public class SabiraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     processRequest(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Naslov</title></head>");
        out.println("<body>");
        String sabirak1String = request.getParameter("sabirak1");
        Double sabirak1 = Double.parseDouble(sabirak1String);
        String sabirak2String = request.getParameter("sabirak2");
        Double sabirak2 = Double.parseDouble(sabirak2String);
        double result = sabirak1+sabirak2;
        out.println("</p> Rezultat je:" + result + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
