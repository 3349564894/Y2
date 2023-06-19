package yq.oa.service.impl;

import yq.oa.dao.DepartmentDao;
import yq.oa.entity.Department;
import yq.oa.service.DepartmentService;
import yq.oa.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<Department> getAllDepartments() throws SQLException {
        SqlSession sqlSession = null;
        List<Department> list;
        try {
            //获取连接
            sqlSession = MyBatisUtil.createSqlSession();
            list = sqlSession.getMapper(DepartmentDao.class).getAllDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return list;
    }
}
