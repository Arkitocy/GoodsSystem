import Entity.Product;
import Entity.User;
import Service.ProductService;
import Service.UserService;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService ps = new ProductService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String productiondate = request.getParameter("productiondate");
        String outdate = request.getParameter("outdate");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        try {
            Product p = new Product();
            p.setId(id);
            p.setName(name);
            p.setCategory(category);
            p.setProductiondate(sdf.parse(productiondate));
            p.setOutdate(sdf.parse(outdate));
            p.setPrice(price);
            p.setAmount(amount);
            if (ps.updateProduct(p)) {
                request.setAttribute("rs", "编辑成功");
            } else {
                request.setAttribute("rs", "编辑失败");

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getRequestDispatcher("index3.jsp").forward(request, response);
    }
}
