package backend;

import entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLAccount {
    // viết method showAllAccount
    public static void showAllAccount() throws ClassNotFoundException{
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
            String sql = "select * from account;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("account_id");// lấy giá trị từ cloumn department_id
                String fullname = rs.getString("full_name");//lấy giá trị từ cloumn department_name
                String email = rs.getString("email");
                System.out.println(id +" "+ fullname + " " +  email);
            }

        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
        }
    }

    // viết method findByFullname
    public static void findByFullname(String searchName) throws ClassNotFoundException{
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
            String sql = "select * from account where full_name like ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + searchName + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                System.out.println(
                        rs.getInt("account_id") + " - " +
                                rs.getString("full_name") + " - " +
                                rs.getString("username")
                );
            }

        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        }
    }

    // viết method findByFullnameAndUsername
    public static void findByFullnameAndUsername(String searchName,String searchUsername) throws ClassNotFoundException{
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
            String sql = "select * from account where full_name like ? and username like ?";
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + searchName + "%");
            statement.setString(2, "%" + searchUsername + "%");
            ResultSet rs = statement.executeQuery();
            boolean found = false;
            while (rs.next()) {// lặp qua qua từng dòng của rs
                found = true;
                System.out.println(
                        rs.getInt("account_id") + " - " +
                                rs.getString("full_name") + " - " +
                                rs.getString("username")
                );
            }
            if (!found) {
                System.out.println("Không tìm thấy account!");
            }
        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        }
    }
}
