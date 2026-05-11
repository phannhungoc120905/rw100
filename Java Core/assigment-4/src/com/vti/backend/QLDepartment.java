package com.vti.backend;

import com.vti.entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {
    //lấy danh sách phòng ban trong DB và in ra
    public static void showDepartment(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "tuansan12345";// mk mysql

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Kết nối DB thành công");
            }

            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);  // thực thi câu lệnh sql
            List<Department> departments = new ArrayList<>(); // lưu lại dữ liệu lấy từ db
            while (rs.next()) {
                int id = rs.getInt("department_id");
                String name = rs.getString("department_name");
                Department dep = new Department(id, name);
                departments.add(dep);
            }
            for (Department de : departments) {
                System.out.println(de);
            }


        } catch (Exception e) {
            System.out.println("Kết nối DB không thành công");
        }


    }
// tìm các phòng ban có chữ xyz chuwa biết trc
    // select * from depaertment where deparment_name like ''
    public static void findByNameAndId(String searchName, int searchId) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "tuansan12345";// mk mysql

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Kết nối DB thành công");
            }

            // b2: tìm phòng ban có tên là name
            String sql = "select * from department where department_name like ? and department_id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,searchName);
            statement.setInt(2,searchId);

            ResultSet rs = statement.executeQuery();  // thực thi câu lệnh sql
            List<Department> departments = new ArrayList<>(); // lưu lại dữ liệu lấy từ db
            while (rs.next()) {
                int id = rs.getInt("department_id");
                String name = rs.getString("department_name");
                Department dep = new Department(id, name);
                departments.add(dep);
            }
            for (Department de : departments) {
                System.out.println(de);
            }

        } catch (Exception e) {
            System.out.println("Kết nối DB không thành công");
            e.printStackTrace();
        }
    }
}
