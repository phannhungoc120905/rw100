package com.vti.backend.controller;

import com.vti.backend.service.IPositionService;
import com.vti.backend.service.impl.PositionServiceImpl;
import com.vti.entity.Position;
import com.vti.enums.PositionName;

import java.util.List;

public class PositionController {
    private IPositionService positionService = new PositionServiceImpl();
    public List<Position> findAll(){
        List<Position> positions = positionService.findAll();
        return positions;
    }

    public boolean delete(int id){
        boolean check = positionService.delete(id);
        return check;
    }

    public boolean checkExistNameAndIdNot(PositionName positionName, Integer id) {
        return positionService.checkExistNameAndIdNot(positionName, id);
    }

    public boolean createPosition(PositionName positionName) {
        return positionService.createPosition(positionName);
    }

    public boolean checkExistID(int id) {
        return positionService.checkExistID(id);
    }

    public boolean update(Integer id, PositionName newName) {
        return positionService.update(id, newName);
    }

    public boolean isPositionUsed(int id) {
        return positionService.isPositionUsed(id);
    }
}
