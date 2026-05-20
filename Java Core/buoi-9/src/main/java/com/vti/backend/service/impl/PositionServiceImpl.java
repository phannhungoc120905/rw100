package com.vti.backend.service.impl;

import com.vti.backend.repository.IPositionRepository;
import com.vti.backend.repository.impl.PositionRepositoryImpl;
import com.vti.backend.service.IPositionService;
import com.vti.entity.Position;
import com.vti.enums.PositionName;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> findAll() {
       List<Position> positions = positionRepository.findAll();
       return positions;
    }

    @Override
    public Boolean delete(int id) {
        boolean check = positionRepository.delete(id);
        return check;
    }

    @Override
    public boolean checkExistNameAndIdNot(PositionName positionName, Integer id) {
        boolean check =  positionRepository.checkExistNameAndIdNot(positionName, id);
        return check;
    }

    @Override
    public boolean createPosition(PositionName positionName) {
        boolean check = positionRepository.createPosition(positionName);
        return check;
    }

    @Override
    public boolean checkExistID(int id) {
        boolean check = positionRepository.checkExistID(id);
        return check;
    }

    @Override
    public boolean update(Integer id, PositionName newName) {
        boolean check = positionRepository.update(id, newName);
        return check;
    }
    @Override
    public boolean isPositionUsed(int id) {

        return positionRepository.isPositionUsed(id);
    }
}
