package yq.oa.dao;

import yq.oa.entity.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionDao {
    // 获取职位列表
    public List<Position> getAllPositions() throws SQLException;
}
