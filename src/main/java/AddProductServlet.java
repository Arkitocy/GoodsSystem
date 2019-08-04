
import Comment.KeyUtils;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddProductServlet")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService ps = new ProductService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String productiondate = request.getParameter("productiondate");
        String outdate = request.getParameter("outdate");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        try {
            Product p = new Product();
            String id = KeyUtils.genUniqueKey();
            p.setId(id);
            p.setName(name);
            p.setCategory(category);
            p.setProductiondate(sdf.parse(productiondate));
            p.setOutdate(sdf.parse(outdate));
            p.setPrice(price);
            p.setAmount(amount);
            if (ps.addProduct(p)) {
                request.setAttribute("rs", "添加成功");
            } else {
                request.setAttribute("rs", "添加失败");

            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getRequestDispatcher("index2.jsp").forward(request, response);

    }
}
