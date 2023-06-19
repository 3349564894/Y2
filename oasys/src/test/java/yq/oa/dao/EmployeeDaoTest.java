package yq.oa.dao;

import yq.oa.entity.Employee;
import yq.oa.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class EmployeeDaoTest {

    private static SqlSession sqlSession;
    private Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findEmployee() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formate2 = new SimpleDateFormat("EEE MMM dd zzz yyyy", Locale.ENGLISH);
        String date = null;
        String time = "Thu Sep 23 CST 2004";
        try {
            date = sdf.format(formate2.parse(time));
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getEmployeesByPage() {
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Employee employee = sqlSession.getMapper(EmployeeDao.class).findEmployee("1000890901", "123456");
            logger.debug("username = " + employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void getEmployeesCount() {
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Employee employee = sqlSession.getMapper(EmployeeDao.class).findEmployee("1000890901", "123456");
            logger.debug("username = " + employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void updateEmployee() {
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Employee employee = sqlSession.getMapper(EmployeeDao.class).findEmployee("1000890901", "123456");
            logger.debug("username = " + employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void addNewEmployee() {
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Employee employee = sqlSession.getMapper(EmployeeDao.class).findEmployee("1000890901", "123456");
            logger.debug("username = " + employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void getEmployeeById() {
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Employee employee = sqlSession.getMapper(EmployeeDao.class).findEmployee("1000890901", "123456");
            logger.debug("username = " + employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void getEmployeeByNo() {
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Employee employee = sqlSession.getMapper(EmployeeDao.class).findEmployee("1000890901", "123456");
            logger.debug("username = " + employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void deleteEmployeeById() {
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Employee employee = sqlSession.getMapper(EmployeeDao.class).findEmployee("1000890901", "123456");
            logger.debug("username = " + employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void updatePasswordById() {
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Employee employee = sqlSession.getMapper(EmployeeDao.class).findEmployee("1000890901", "123456");
            logger.debug("username = " + employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
}