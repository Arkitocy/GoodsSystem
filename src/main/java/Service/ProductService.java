package Service;


import Comment.Connecter;
import Comment.KeyUtils;
import Entity.Product;


import java.sql.*;
import java.util.ArrayList;

public class ProductService {
    Connecter connecter = new Connecter();
    Connection cn = null;


    public boolean addProduct(Product product) {
        boolean f = false;
        try {

            cn = connecter.getConnetcion();
            String sql = "insert into product(id,name,category,productiondate,outdate,price,amount) values (?,?,?,?,?,?,?);";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, KeyUtils.genUniqueKey());
            ps.setString(2, product.getName());
            ps.setString(3, product.getCategory());
            ps.setTimestamp(4, new Timestamp(product.getProductiondate().getTime()));
            ps.setTimestamp(5, new Timestamp(product.getOutdate().getTime()));
            ps.setBigDecimal(6, product.getPrice());
            ps.setInt(7, product.getAmount());
            int rs = ps.executeUpdate();
            if (rs >= 1) {
                f = true;
            }
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
            return f;
        }
    }

    public boolean deleteProduct(String id) {
        boolean f = false;
        try {
            cn = connecter.getConnetcion();
            String sql = "delete from product where id=?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            if (rs >= 1) {
                f = true;
            }
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
            return f;
        }
    }

    public boolean updateProduct(Product product) {
        boolean f = false;
        try {
            cn = connecter.getConnetcion();
            String sql1 = "update  product set name = ?,productiondate =?,outdate =? ,price=? ,amount=? where id=?;";
            PreparedStatement ps1 = cn.prepareStatement(sql1);
            ps1.setString(1, product.getName());
            ps1.setTimestamp(2, new Timestamp(product.getProductiondate().getTime()));
            ps1.setTimestamp(3, new Timestamp(product.getOutdate().getTime()));
            ps1.setBigDecimal(4, product.getPrice());
            ps1.setInt(5, product.getAmount());
            ps1.setString(6, product.getId());
            int rs = ps1.executeUpdate();
            if (rs >= 1) {
                f = true;
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
            return f;
        }
    }

    public boolean changeAmount(String id, int amount) {
        boolean f = false;
        try {
            cn = connecter.getConnetcion();
            int a = 0;
            String sql1 = "select * from product where id=?";
            PreparedStatement ps1 = cn.prepareStatement(sql1);
            ps1.setString(1, id);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                a = rs.getInt("amount");
            }
            if (a > amount) {
                String sql2 = "update product set amount=? where id=?";
                PreparedStatement ps2 = cn.prepareStatement(sql2);
                ps2.setInt(1, amount);
                ps2.setString(2, id);
                int rs2 = ps2.executeUpdate();
                if (rs2 >= 1) {
                    f = true;
                }
                ps2.close();
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
            return f;

        }
    }

    public ArrayList<Product> showProduct(String name) {
        ArrayList<Product> ap = new ArrayList();
        try {
            cn = connecter.getConnetcion();
            String sql = "select * from product where name= ? ;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p1 = new Product();
                p1.setId(rs.getString("id"));
                p1.setName(rs.getString("name"));
                p1.setCategory(rs.getString("category"));
                p1.setProductiondate(rs.getTimestamp("productiondate"));
                p1.setOutdate(rs.getTimestamp("outdate"));
                p1.setOutdate(rs.getTimestamp("outdate"));
                p1.setPrice(rs.getBigDecimal("price"));
                p1.setAmount(rs.getInt("amount"));
                ap.add(p1);
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
            return ap;

        }

    }


    public Product selectProduct(String id) {
        Product p1 = null;
        try {
            cn = connecter.getConnetcion();
            String sql = "select * from product where id =?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p1 = new Product();
                p1.setId(rs.getString("id"));
                p1.setName(rs.getString("name"));
                p1.setCategory(rs.getString("category"));
                p1.setProductiondate(rs.getTimestamp("productiondate"));
                p1.setOutdate(rs.getTimestamp("outdate"));
                p1.setOutdate(rs.getTimestamp("outdate"));
                p1.setPrice(rs.getBigDecimal("price"));
                p1.setAmount(rs.getInt("amount"));
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
            return p1;
        }
    }


    public ArrayList<Product> showAll() {

        ArrayList<Product> ap = new ArrayList();
        try {
            cn = connecter.getConnetcion();
            String sql = "select * from product ;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p1 = new Product();
                p1.setId(rs.getString("id"));
                p1.setName(rs.getString("name"));
                p1.setCategory(rs.getString("category"));
                p1.setProductiondate(rs.getTimestamp("productiondate"));
                p1.setOutdate(rs.getTimestamp("outdate"));
                p1.setOutdate(rs.getTimestamp("outdate"));
                p1.setPrice(rs.getBigDecimal("price"));
                p1.setAmount(rs.getInt("amount"));
                ap.add(p1);
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
            return ap;

        }

    }
}
