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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CheckUserNameServlet")
public class ChangeAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductService ps = new ProductService();
        Product p = ps.selectProduct(id);
        Map rsmap = new HashMap();
        rsmap.put("product",p);
        String rs1 = JSONObject.toJSONString(rsmap);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().append(rs1);
    }
}
