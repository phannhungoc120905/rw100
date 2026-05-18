package com.vti.backend.repository;

import com.vti.entity.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();
    Boolean create(Position pos);
    Boolean delete(int id);
    Boolean update(Position pos);
}
