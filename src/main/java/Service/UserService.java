package Service;

import Entity.User;
import Comment.Connecter;
import Comment.KeyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    Connection cn = null;

    public User registUser(String name, String pwd) {
        User user = null;
        try {
            cn = new Connecter().getConnetcion();
            String id = KeyUtils.genUniqueKey();
            String sql1 = "insert into tb_user(id,username,password) values (?,?,?);";
            PreparedStatement ps1 = cn.prepareStatement(sql1);
            ps1.setString(1, id);
            ps1.setString(2, name);
            ps1.setString(3, pwd);
            int rs = ps1.executeUpdate();
            if (rs >= 1) {
                user = new User(id, name, pwd);
            }
            ps1.close();

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
        }
        return user;
    }

    public User loginUser(String name, String pwd, String type) {
        User user = null;
        try {
            cn = new Connecter().getConnetcion();
            String sql = "select * from tb_user where username= ? and password=?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("登陆失败");
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return user;
        }
    }

    public User findByName(String name) {
        User user = null;
        try {
            cn = new Connecter().getConnetcion();
            String sql = "select * from tb_user where username = ?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }
}
