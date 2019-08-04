import Entity.Product;
import Service.ProductService;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet(name = "AddAmountServlet")
public class AddAmountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService ps = new ProductService();
        int amount = Integer.parseInt(request.getParameter("num"));
        String id =request.getParameter("id");
        boolean f =ps.changeAmount(id,amount);
        String rs = JSONObject.toJSONString(f);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().append(rs);

    }
}
