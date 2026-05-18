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
    public Boolean create(Position pos) {
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: update department
            String sql = "INSERT INTO position(position_name) VALUES (?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pos.getName().name());
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
    public Boolean update(Position pos) {
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "UPDATE position SET position_name = ? WHERE position_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pos.getName().name());
            statement.setInt(2, pos.getId());

            int c = statement.executeUpdate();

            JDBCUtils.closeConnection(connection, statement, null);

            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
