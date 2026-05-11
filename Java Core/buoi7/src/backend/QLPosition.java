package backend;

import entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLPosition {
    // viết method showAllPosition()
    public static void showAllPosition() throws ClassNotFoundException{
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
            // b2: lấy dữ liệu từ bảng position
            String sql = "select * from position;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("position_name");//lấy giá trị từ cloumn department_name
                System.out.println(id + " - " + name);
            }

        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
        }
    }

    // viết method findByPoistionName
    public static void findByPositionName(String searchName) throws ClassNotFoundException{
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
            // b2: lấy dữ liệu từ bảng position
            String sql = "SELECT * FROM position WHERE position_name LIKE ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + searchName + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("position_name");//lấy giá trị từ cloumn department_name
                System.out.println(id + " - " + name);
            }

        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        }
    }




}
