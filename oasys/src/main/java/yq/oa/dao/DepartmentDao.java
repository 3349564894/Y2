package yq.oa.dao;

import yq.oa.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {
    //获取部门列表
    public List<Department> getAllDepartments() throws SQLException;
}
