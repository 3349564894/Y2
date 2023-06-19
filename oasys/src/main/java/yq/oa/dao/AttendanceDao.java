package yq.oa.dao;

import yq.oa.entity.Attendance;
import org.apache.ibatis.annotations.Param;
import java.sql.SQLException;
import java.util.List;

public interface AttendanceDao {
    //删除员工的所有考勤记录
    public int deleteAttendanceByEmployeeId(@Param("employeeId") int employeeId) throws SQLException;

    //查找打卡记录
    public Attendance getRecordByEmployeeIdAndDate(@Param("employeeId") int employeeId, @Param("date") String date) throws SQLException;

    //上班打卡
    public int addSinginByEmployeeId(@Param("employeeId") int employeeId, @Param("now") String now) throws SQLException;

    //根据考勤id记录签退
    public int updateSingoutByAttendanceId(@Param("id") int id, @Param("now") String now) throws SQLException;

    //获取考勤记录
    public List<Attendance> getAttendancesByPage(@Param("name") String name, @Param("searchDate") String searchDate, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize) throws SQLException;

    //获取记录总数
    public int getAttendancesCount(@Param("name") String name, @Param("searchDate") String searchDate) throws SQLException;
}
