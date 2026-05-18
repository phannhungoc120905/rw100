package com.vti.backend.controller;

import com.vti.backend.service.IPositionService;
import com.vti.backend.service.impl.PositionServiceImpl;
import com.vti.entity.Position;

import java.util.List;

public class PositionController {
    private IPositionService positionService = new PositionServiceImpl();
    public List<Position> findAll(){
        List<Position> positions = positionService.findAll();
        return positions;
    }
    public boolean create(Position pos){
        boolean check = positionService.create(pos);
        return check;
    }
    public boolean delete(int id){
        boolean check = positionService.delete(id);
        return check;
    }
    public boolean update(Position pos){
        boolean check = positionService.update(pos);
        return check;
    }
}
