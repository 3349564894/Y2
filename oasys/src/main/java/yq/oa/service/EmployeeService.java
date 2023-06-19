package yq.oa.service;

import yq.oa.entity.Employee;
import yq.oa.util.Page;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface EmployeeService {
    //查找员工
    public Employee findEmployee(String employeeNo, String password) throws SQLException;

    //获取员工列表
    public void getEmployeesByPage(@Param("name") String name, Page pageObj) throws SQLException;

    //修改员工信息
    public int updateEmployee(Employee employee) throws SQLException;

    //新增员工
    public int addNewEmployee(Employee employee) throws SQLException;

    //根据ID获取员工信息
    public Employee getEmployeeById(int id) throws SQLException;

    //删除员工
    public int deleteEmployeeById(int id) throws SQLException;

    //更新用户密码
    public int updatePassword(@Param("id") int id, @Param("pwd") String pwd) throws SQLException;
}
