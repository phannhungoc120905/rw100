package com.vti.backend.repository;

import com.vti.entity.Position;
import com.vti.enums.PositionName;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();
    Boolean delete(int id);
    boolean checkExistID(int id);
    boolean update(Integer id, PositionName newName);
    boolean checkExistNameAndIdNot(PositionName positionName, Integer id);
    boolean createPosition(PositionName positionName);
    boolean isPositionUsed(int id);
}
