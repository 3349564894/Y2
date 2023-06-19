package yq.oa.service.impl;

import yq.oa.dao.AttendanceDao;
import yq.oa.dao.EmployeeDao;
import yq.oa.entity.Employee;
import yq.oa.service.EmployeeService;
import yq.oa.util.MyBatisUtil;
import yq.oa.util.Page;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private SqlSession sqlSession;

    @Override
    public Employee findEmployee(String employeeNo, String password) throws SQLException {
        Employee employee = null;
        try {
            //获取连接
            sqlSession = MyBatisUtil.createSqlSession();
            employee = sqlSession.getMapper(EmployeeDao.class).findEmployee(employeeNo, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return employee;
    }

    @Override
    public void getEmployeesByPage(String name, Page pageObj) throws SQLException {
        try {
            //获取连接
            sqlSession = MyBatisUtil.createSqlSession();
            int totalCount = sqlSession.getMapper(EmployeeDao.class).getEmployeesCount(name);
            pageObj.setTotalCount(totalCount);
            if (totalCount > 0) {
                if (pageObj.getCurrPageNo() > pageObj.getTotalPageCount()) {
                    pageObj.setCurrPageNo(pageObj.getTotalPageCount());
                }
                List<Employee> empList = sqlSession.getMapper(EmployeeDao.class).getEmployeesByPage(name, pageObj.getOffset(), pageObj.getPageSize());
                pageObj.setEmployeeList(empList);
            } else {
                pageObj.setCurrPageNo(0);
                pageObj.setEmployeeList(new ArrayList<Employee>());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            //关闭连接
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int updateEmployee(Employee employee) throws SQLException {
        int result;
        try {
            //获取连接
            sqlSession = MyBatisUtil.createSqlSession();
            result = sqlSession.getMapper(EmployeeDao.class).updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            //关闭连接
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }

    @Override
    public int addNewEmployee(Employee employee) throws SQLException {
        int result;
        try {
            //获取连接
            sqlSession = MyBatisUtil.createSqlSession();
            if (sqlSession.getMapper(EmployeeDao.class).getEmployeeByNo(employee.getEmployeeNo()) > 0) {
                //该员工号已存在
                result = -1;
            } else {
                //新增员工
                result = sqlSession.getMapper(EmployeeDao.class).addNewEmployee(employee);
            }
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw e;
        } finally {
            //关闭连接
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        try {
            //获取连接
            sqlSession = MyBatisUtil.createSqlSession();
            return sqlSession.getMapper(EmployeeDao.class).getEmployeeById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            //关闭连接
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int deleteEmployeeById(int id) throws SQLException {
        int result = 0;
        try {
            //获取连接
            sqlSession = MyBatisUtil.createSqlSession();
            //删除员工的所有考核记录
            sqlSession.getMapper(AttendanceDao.class).deleteAttendanceByEmployeeId(id);
            //删除员工的信息
            result = sqlSession.getMapper(EmployeeDao.class).deleteEmployeeById(id);
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
                result = -1;
            }
            throw e;
        } finally {
            //关闭连接
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }

    @Override
    public int updatePassword(int id, String pwd) throws SQLException {
        int result;
        try {
            //获取连接
            sqlSession = MyBatisUtil.createSqlSession();
            result = sqlSession.getMapper(EmployeeDao.class).updatePasswordById(id, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            //关闭连接
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }
}


