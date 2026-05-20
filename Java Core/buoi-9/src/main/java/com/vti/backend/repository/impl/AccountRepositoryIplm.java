package com.vti.backend.repository.impl;

import com.vti.backend.repository.IAccountRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.enums.PositionName;
import com.vti.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryIplm implements IAccountRepository {

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de  on acc.department_id = de.department_id\n" +
                    "left join position po on po.position_id = acc.position_id;\n";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                Integer id = rs.getInt("account_id");// lấy giá trị từ cloumn account_id
                String email = rs.getString("email");//lấy giá trị từ cloumn account_name
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                Integer departmentID = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Integer positionID = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                LocalDate createDate = rs.getDate("create_date").toLocalDate();
                // trả ra 1 đối tượng Date          // chuyển thành LocalDate

                Department department = new Department(departmentID, departmentName);
                Position position = new Position(positionID, PositionName.valueOf(positionName));

                Account account = new Account(id, userName, fullName, email, department, position, createDate);
                accounts.add(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Boolean create(Account acc) {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "INSERT INTO account(username, full_name, email, department_id, position_id, create_date)\n" +
                    "            VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, acc.getUsername());
            statement.setString(2, acc.getFullName());
            statement.setString(3, acc.getEmail());
            statement.setInt(4, acc.getDepartment().getId());
            statement.setInt(5, acc.getPosition().getId());
            statement.setDate(6, java.sql.Date.valueOf(acc.getCreateDate()));

            int rows = statement.executeUpdate();

            JDBCUtils.closeConnection(connection, statement, null);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(Account acc) {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "UPDATE account \n" +
                    "            SET username = ?, full_name = ?, email = ?, department_id = ?, position_id = ?, create_date = ?\n" +
                    "            WHERE account_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, acc.getUsername());
            statement.setString(2, acc.getFullName());
            statement.setString(3, acc.getEmail());
            statement.setInt(4, acc.getDepartment().getId());
            statement.setInt(5, acc.getPosition().getId());
            statement.setDate(6, java.sql.Date.valueOf(acc.getCreateDate()));
            statement.setInt(7, acc.getId());

            int rows = statement.executeUpdate();

            JDBCUtils.closeConnection(connection, statement, null);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "DELETE FROM account WHERE account_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            JDBCUtils.closeConnection(connection, statement, null);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistUsernameAndIdNot(String username, Integer id) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql;
            if (id == null) {
                sql = "SELECT COUNT(1) " +
                        "FROM account " +
                        "WHERE username = ?";
            }
            // UPDATE
            else {

                sql = "SELECT COUNT(1) " +
                        "FROM account " +
                        "WHERE username = ? " +
                        "AND account_id <> ?";
            }

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, username);

            if (id != null) {
                statement.setInt(2, id);
            }

            ResultSet rs = statement.executeQuery();

            boolean isExist = false;

            if (rs.next()) {
                isExist = rs.getInt(1) > 0;
            }

            JDBCUtils.closeConnection(connection, statement, rs);

            return isExist;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean checkExistEmailAndIdNot(String email, Integer id) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql;
            if (id == null) {
                sql =
                        "SELECT COUNT(1) " +
                                "FROM account " +
                                "WHERE email = ?";
            } else {
                sql =
                        "SELECT COUNT(1) " +
                                "FROM account " +
                                "WHERE email = ? " +
                                "AND account_id <> ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            if (id != null) {
                statement.setInt(2, id);
            }
            ResultSet rs = statement.executeQuery();

            boolean isExist = false;
            if (rs.next()) {
                isExist = rs.getInt(1) > 0;
            }
            JDBCUtils.closeConnection(connection, statement, rs);
            return isExist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistPositionID(int posId) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql =
                    "SELECT COUNT(1) " +
                            "FROM position " +
                            "WHERE position_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, posId);
            ResultSet rs = statement.executeQuery();
            boolean isExist = false;
            if (rs.next()) {
                isExist = rs.getInt(1) > 0;
            }
            JDBCUtils.closeConnection(connection, statement, rs);
            return isExist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistID(int id) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql =
                    "SELECT COUNT(1) " +
                            "FROM account " +
                            "WHERE account_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            boolean isExist = false;
            if (rs.next()) {
                isExist = rs.getInt(1) > 0;
            }
            JDBCUtils.closeConnection(connection, statement, rs);
            return isExist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistDepartmentID(int depId) {
        boolean check = false;
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department where department_id = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, depId);

            ResultSet rs = preparedStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                check = true;
            }
            // đóng các kết nối
            JDBCUtils.closeConnection(connection, preparedStatement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return check;
    }

    @Override
    public boolean updateUsername(int id, String newUsername) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql =
                    "UPDATE account " +
                            "SET username = ? " +
                            "WHERE account_id = ?";
            PreparedStatement statement =
                    connection.prepareStatement(sql);
            statement.setString(1, newUsername);
            statement.setInt(2, id);
            int rows = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
