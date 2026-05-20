package com.vti.backend.repository.impl;

import com.vti.backend.repository.IPositionRepository;
import com.vti.entity.Position;
import com.vti.enums.PositionName;
import com.vti.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {
    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng position
            String sql = "select * from position;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");// lấy giá trị từ cloumn position_id
                String name = rs.getString("position_name");//lấy giá trị từ cloumn position_name
                // chuyển từ positionName tu String -> enum PositionName
                PositionName positionName = PositionName.valueOf(name);

                // chuyển từ enum -> String
//                positionName.name();

                Position po = new Position(id, positionName);
                positions.add(po);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return positions;
    }


    @Override
    public Boolean delete(int id) {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: update department
            String sql = "DELETE FROM position WHERE position_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int c = statement.executeUpdate();// trả ra số row thay đổi trong DB
            JDBCUtils.closeConnection(connection, statement, null);
            // c= 0
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistID(int id) {

        try {

            Connection connection =
                    JDBCUtils.getConnection();

            String sql =
                    "SELECT count(1) " +
                            "FROM position " +
                            "WHERE position_id = ?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            boolean isExists = false;

            if (rs.next()) {

                isExists = rs.getInt(1) > 0;
            }

            JDBCUtils.closeConnection(
                    connection,
                    statement,
                    rs
            );

            return isExists;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Integer id, PositionName newName) {
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "UPDATE position SET position_name = ? WHERE position_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, newName.name());
            statement.setInt(2, id);

            int c = statement.executeUpdate();

            JDBCUtils.closeConnection(connection, statement, null);

            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistNameAndIdNot(PositionName positionName, Integer id) {
        try {

            Connection connection =
                    JDBCUtils.getConnection();

            String sql;
            // create
            if (id == null) {

                sql =
                        "SELECT count(1) " +
                                "FROM position " +
                                "WHERE position_name = ?";

            }
            // update
            else {
                sql =
                        "SELECT count(1) " +
                                "FROM position " +
                                "WHERE position_name = ? " +
                                "AND position_id <> ?";
            }

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(
                    1,
                    positionName.name()
            );
            // chỉ set id khi update
            if (id != null) {

                statement.setInt(2, id);
            }

            ResultSet rs =
                    statement.executeQuery();

            boolean isExists = false;

            if (rs.next()) {

                isExists = rs.getInt(1) > 0;
            }

            JDBCUtils.closeConnection(
                    connection,
                    statement,
                    rs
            );

            return isExists;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean createPosition(PositionName positionName) {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: update department
            String sql = "INSERT INTO position(position_name) VALUES (?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, positionName.name());
            // thực thi câu sql
            int c = statement.executeUpdate();// trả ra số row thay đổi trong DB
            JDBCUtils.closeConnection(connection, statement, null);
            // c= 0
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isPositionUsed(int id) {

        try {

            Connection connection =
                    JDBCUtils.getConnection();

            String sql =
                    "SELECT count(1) " +
                            "FROM account " +
                            "WHERE position_id = ?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs =
                    statement.executeQuery();

            boolean isUsed = false;

            if (rs.next()) {

                isUsed = rs.getInt(1) > 0;
            }

            JDBCUtils.closeConnection(
                    connection,
                    statement,
                    rs
            );

            return isUsed;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}

