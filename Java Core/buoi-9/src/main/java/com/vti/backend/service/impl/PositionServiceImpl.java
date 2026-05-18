package com.vti.backend.service.impl;

import com.vti.backend.repository.IPositionRepository;
import com.vti.backend.repository.impl.PositionRepositoryImpl;
import com.vti.backend.service.IPositionService;
import com.vti.entity.Position;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> findAll() {
       List<Position> positions = positionRepository.findAll();
       return positions;
    }

    @Override
    public Boolean create(Position pos) {
        boolean check = positionRepository.create(pos);
        return check;
    }

    @Override
    public Boolean delete(int id) {
        boolean check = positionRepository.delete(id);
        return check;
    }

    @Override
    public Boolean update(Position pos) {
        boolean check = positionRepository.update(pos);
        return check;
    }
}
