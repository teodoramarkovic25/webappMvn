package com.akademija.webappmvn.shop;

import com.akademija.webappmvn.shop.model.Product;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "WebShopServlet", urlPatterns = {"/shop"})
public class WebShopServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();
        try (BufferedReader br = new BufferedReader(new FileReader(servletContext.getRealPath("products.txt")))) {
            List<Product> products = new ArrayList<>();
            String line = null;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                Integer id = Integer.parseInt(tokenizer.nextToken());
                String productName = tokenizer.nextToken();
                Double price = Double.parseDouble(tokenizer.nextToken());
                Product product = new Product(id, productName, price);
                products.add(product);
            }
            servletContext.setAttribute("products", products);


        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>WEB shop</title></head>");
        out.println("<body>");
        out.println("<h1> Raspoloživi proizvodi</h1>");
        List<Product> products = (List<Product>) getServletContext().getAttribute("products");
        if (products != null) {


            out.println("<table border = '1'>");
            out.println("<tr bgcolor= 'lightgray'> <th>Naziv</th><th>Cijena</th><th>Dodaj u korpu</th>");
            for (Product product : products) {
                out.println("<tr>");
                out.println("<td>" + product.getProductName() + "</td>");
                out.println("<td>" + product.getPrice() + "</td>");
                out.println("<td>");
                out.println("<form action = 'korpa' method = 'GET'>" + "<input type = 'number' name = 'quantity' size = '3'/>"

                        + "<input type = 'submit' value = 'Dodaj' />" + "<input type = 'hidden' value ='" + product.getId() + "' name ='productId'/>");

                out.println("</form>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } else {
            out.println("<h4>Trenutno nismo u mogućnosti da prikažemo raspoložive proizvode u shopu </h4>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
