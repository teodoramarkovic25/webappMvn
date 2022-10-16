package com.akademija.webappmvn.generator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Enumeration;

@WebServlet(name = "PasswordGeneratorServlet", urlPatterns = {"/generisi", "/lozinka"})
public class PasswordGeneratorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Naslov</title></head>");
        out.println("<body>");
        String password = new PasswordGenerator().generate();
        out.println("<h1> Generisana lozinka je:" + password + " </h1>");
        Enumeration<String> headerNames = request.getHeaderNames();
        out.println("<p>");
        while (headerNames.hasMoreElements()) {

            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println(headerName+":"+ headerValue+"<br>");
        }
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
