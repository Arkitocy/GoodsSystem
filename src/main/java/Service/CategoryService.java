package Service;

import Comment.Connecter;
import Entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryService {
    Connecter connecter = new Connecter();
    Connection cn = null;

    public ArrayList<Category> showCategory() {
        ArrayList<Category> arrayList = new ArrayList<>();
        try {
            cn = connecter.getConnetcion();
            String sql = "select * from category ;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getString("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;

        }

    }
}
