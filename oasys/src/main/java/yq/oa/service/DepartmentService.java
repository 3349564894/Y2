package yq.oa.service;

import yq.oa.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService {
    //部门列表
    public List<Department> getAllDepartments() throws SQLException;
}
