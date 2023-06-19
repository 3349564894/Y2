package yq.oa.dao;

import yq.oa.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    //查找员工
    public Employee findEmployee(@Param("employeeNo") String employeeNo, @Param("password") String password) throws SQLException;

    //获取员工列表
    public List<Employee> getEmployeesByPage(@Param("name") String name, @Param("offset") int offset, @Param("pageSize") int pageSize) throws SQLException;

    //获取员工总数
    public int getEmployeesCount(String name) throws SQLException;

    //修改员工信息
    public int updateEmployee(Employee employee) throws SQLException;

    //新增员工
    public int addNewEmployee(Employee employee) throws SQLException;

    //根据ID获取员工信息
    public Employee getEmployeeById(int id) throws SQLException;

    //根据工号查询
    public int getEmployeeByNo(String employeeNo) throws SQLException;

    //删除员工
    public int deleteEmployeeById(int id) throws SQLException;

    //更新用户密码
    public int updatePasswordById(@Param("id") int id, @Param("pwd") String pwd) throws SQLException;
}
