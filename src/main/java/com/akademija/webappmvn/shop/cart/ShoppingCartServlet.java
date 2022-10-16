package com.akademija.webappmvn.shop.cart;

import com.akademija.webappmvn.shop.cart.model.Cart;
import com.akademija.webappmvn.shop.cart.model.CartItem;
import com.akademija.webappmvn.shop.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/korpa"})
public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Product product = findProductById(productId);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.AddCartItem(product, quantity);
        out.println("<h1> Proizvodi u korpi</h1>");



            out.println("<table border = '1'>");
            out.println("<tr bgcolor= 'lightgray'> <th>Naziv</th><th>Jedinična cijeena </th><th>Količina</th><th>Ukupna cijena </th>");
            for (CartItem cartItem: cart.getCartItems()) {
                out.println("<tr>");
                out.println("<td>" + cartItem.getProduct().getProductName() + "</td>");
                out.println("<td>" + cartItem.getProduct().getPrice()+ "</td>");
                out.println("<td>" + cartItem.getQuantity()+ "</td>");
                out.println("<td>" + cartItem.getTotalPrice()+ "</td>");



                out.println("</tr>");
            }
            out.println("</table>");



        }

        private Product findProductById (Integer productId){

            List<Product> products = (List<Product>) getServletContext().getAttribute("products");
            for (Product product : products) {
                if (product.getId() == productId) {
                    return product;
                }

            }
            return null;

        }

    }

