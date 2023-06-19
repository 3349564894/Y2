package yq.oa.service.impl;

import yq.oa.dao.PositionDao;
import yq.oa.entity.Position;
import yq.oa.service.PositionService;
import yq.oa.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class PositionServiceImpl implements PositionService {
    @Override
    public List<Position> getAllPositions() throws SQLException {
        SqlSession sqlSession = null;
        try {
            //获取连接
            sqlSession = MyBatisUtil.createSqlSession();
            return sqlSession.getMapper(PositionDao.class).getAllPositions();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
}
