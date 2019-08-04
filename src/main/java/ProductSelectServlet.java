
import Entity.Product;
import Service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet(name = "ProductSelectServlet")
public class ProductSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService ps = new ProductService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String name = request.getParameter("name");
        ArrayList<Product> arrayList = ps.showProduct(name);
        HttpSession se1 = request.getSession();
        se1.setAttribute("productlist", arrayList);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.sendRedirect("index3.jsp");
    }
}
