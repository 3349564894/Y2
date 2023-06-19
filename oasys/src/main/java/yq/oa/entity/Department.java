package yq.oa.entity;

import java.io.Serializable;

/**
 * 部门 实体类
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 4257700387533920926L;
    private int id;
    private String deptName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
