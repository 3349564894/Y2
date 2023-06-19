package yq.oa.service;

import yq.oa.util.Page;

import java.sql.SQLException;


public interface AttendanceService {
    //员工上班打卡
    public int addSignInByEmployeeId(int employeeId, String date) throws SQLException;

    //员工下班打卡
    public int addSignOutByEmployeeId(int employeeId, String date) throws SQLException;

    //查询考勤记录
    public void getAttendancesByPage(String name, String searchDate, Page pageObj) throws SQLException;
}
