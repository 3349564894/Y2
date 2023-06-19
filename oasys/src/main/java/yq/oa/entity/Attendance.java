package yq.oa.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 考勤 实体类
 */
public class Attendance implements Serializable {
    private static final long serialVersionUID = 1575826685999881660L;

    private int id;
    private int empId;
    private Date signInTime;
    private Date signOutTime;
    private Employee employee = new Employee();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public Date getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(Date signOutTime) {
        this.signOutTime = signOutTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
