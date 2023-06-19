package yq.oa.service;

import yq.oa.entity.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionService {
    //职位列表
    public List<Position> getAllPositions() throws SQLException;
}
