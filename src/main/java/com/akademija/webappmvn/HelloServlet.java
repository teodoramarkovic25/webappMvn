package com.akademija.webappmvn;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
        out.println("<head><title>Naslov</title></head>");
        out.println("<body>");
        out.println("<h1> Sada je tačno :" + LocalDateTime.now() + "</h1>");
        out.println("<form>");
        out.println("<input type = 'date'/>");
        out.println("<br/>");
        out.println("<input type = 'color'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
