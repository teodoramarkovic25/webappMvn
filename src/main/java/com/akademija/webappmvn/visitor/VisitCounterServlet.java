package com.akademija.webappmvn.visitor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VisitCounterServlet", value = "/counter")
public class VisitCounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Counter ukupnoCounter = (Counter) servletContext.getAttribute("UKUPNO_POSJETA");
        if (ukupnoCounter == null) {
            ukupnoCounter = new Counter();
            servletContext.setAttribute("UKUPNO_POSJETA", ukupnoCounter);

        }
        ukupnoCounter.increment();
        //pojedinačno posjeta
        HttpSession session = request.getSession();
        Counter pojedincniCounter = (Counter) session.getAttribute("POJEDINACNE_POSJETE");
        if (pojedincniCounter == null) {
            pojedincniCounter = new Counter();
            session.setAttribute("POJEDINACNE_POSJETE",pojedincniCounter);
        }
        pojedincniCounter.increment();
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Naslov</title></head>");
        out.println("<body>");
        out.println("<p> Ukupan broj posjeta:" + ukupnoCounter.getCount() + "</p>");
        out.println("<p> POjedinacni broj posjeta:" + pojedincniCounter.getCount() + "</p>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
