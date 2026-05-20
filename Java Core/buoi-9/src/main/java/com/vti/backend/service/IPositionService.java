package com.vti.backend.service;

import com.vti.entity.Position;
import com.vti.enums.PositionName;

import java.util.ArrayList;
import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    Boolean delete(int id);
    boolean checkExistNameAndIdNot(PositionName positionName, Integer id);

    boolean createPosition(PositionName positionName);

    boolean checkExistID(int id);

    boolean update(Integer id, PositionName newName);

    boolean isPositionUsed(int id);
}
