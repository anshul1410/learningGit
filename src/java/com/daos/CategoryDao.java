
package com.daos;

import com.beans.Category;
import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDao {

    public boolean add(Category Category) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                String sql = "Insert into category(name) values(?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, Category.getName());
                smt.executeUpdate();

                status = true;
                cp.putConnection(con);
                smt.close();

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }

        }
        return status;
    }

    public boolean removeById(int id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Delete from category where cat_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Category Removed !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public Category getById(int id) {
        Category Category = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from category where cat_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    Category = new Category();
                    Category.setId(rs.getInt("id"));
                    Category.setName(rs.getString("name"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return Category;
    }

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> CategoryList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from category";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Category Category = new Category();
                    Category.setId(rs.getInt("cat_id"));
                    Category.setName(rs.getString("name"));
                    CategoryList.add(Category);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return CategoryList;
    }

    public ArrayList<Category> getCategoryByLimit(int start, int stop) {
        ArrayList<Category> CategoryList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from category limit ?, ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, stop);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Category Category = new Category();
                    Category.setId(rs.getInt("id"));
                    Category.setName(rs.getString("name"));
                    CategoryList.add(Category);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return CategoryList;
    }

    public int getCategoryCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select count(*) from category";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return total;

    }

    public boolean update(Category Category) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                String sql = "update category set name=?  where id = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, Category.getName());
                smt.setInt(2, Category.getId());
                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                }
                smt.close();

            } catch (Exception e) {

                System.out.println("Error " + e.getMessage());
            }

        }

        return status;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}

