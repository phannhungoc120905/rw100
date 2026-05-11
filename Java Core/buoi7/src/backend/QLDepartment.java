package backend;


import entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {

    // lấy ds các phòng ban trong DB và in ra
    public static void showDepartment() throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "tuansan12345";// mk mysql

        try {
            // b1: kết nối đến DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Kết nối DB thành công");
            }
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            List<Department> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
            for (Department de: departments) {
                System.out.println(de);
            }

        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
        }
    }

    // tìm các phòng ban có chữ xyz  chưa biết trước
    //  select * from department where department_name like '...';

    public static void findByNameAndId(String searchName, int searchId) throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "tuansan12345";// mk mysql

        try {
            // b1: kết nối đến DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Kết nối DB thành công");
            }
            // b2: tìm các phòng ban có tên là name
            String sql = "select * from department where department_name like ? and department_id = ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchName);// truyền giá trị searchName vào ? đầu tiên
            statement.setInt(2, searchId);// truyền giá trị 2 vào ? thứ2
            ResultSet rs = statement.executeQuery();
            List<Department> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
            for (Department de: departments) {
                System.out.println(de);
            }

        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
        }
    }

    // Cho ra tên phòng ban cs nhiều hơn 2 nhân viên
    public static void showNameDepartment() throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "tuansan12345";// mk mysql

        try {
            // b1: kết nối đến DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Kết nối DB thành công");
            }
            // b2: tìm các phòng ban có account >= 2
            String sql = "SELECT d.department_id, d.department_name, COUNT(a.account_id) AS total\n" +
                    "            FROM department d\n" +
                    "            JOIN account a ON d.department_id = a.department_id\n" +
                    "            GROUP BY d.department_id, d.department_name\n" +
                    "            HAVING COUNT(a.account_id) >= 2";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Department> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
            while (rs.next()) {// lặp qua qua từng dòng của rs
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name;
                int total = rs.getInt("total");

                System.out.println(name + " - Số nhân viên: " + total);
            }

        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        }
    }


}