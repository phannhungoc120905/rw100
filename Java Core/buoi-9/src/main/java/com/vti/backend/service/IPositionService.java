package com.vti.backend.service;

import com.vti.entity.Position;

import java.util.ArrayList;
import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    Boolean create(Position pos);
    Boolean delete(int id);
    Boolean update(Position pos);
}
