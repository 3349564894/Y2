package yq.oa.service.impl;

import yq.oa.dao.AttendanceDao;
import yq.oa.entity.Attendance;
import yq.oa.service.AttendanceService;
import yq.oa.util.DateUtil;
import yq.oa.util.MyBatisUtil;
import yq.oa.util.Page;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {
    private SqlSession sqlSession;

    @Override
    public int addSignInByEmployeeId(int employeeId, String date) throws SQLException {
        int result = 0;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            AttendanceDao attendanceDao = sqlSession.getMapper(AttendanceDao.class);
            //查询员工是否有上班打卡记录
            Attendance record = attendanceDao.getRecordByEmployeeIdAndDate(employeeId, date);
            if (record == null) {
                //执行打卡
                result = attendanceDao.addSinginByEmployeeId(employeeId, DateUtil.now());
            } else {
                //已完成上班打卡,不允许重复打卡
                result = 0;
            }
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
                result = -1;
            }
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }

    @Override
    public int addSignOutByEmployeeId(int employeeId, String date) throws SQLException {
        int result = 0;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            //查询员工是否有上班打卡记录
            Attendance record = sqlSession.getMapper(AttendanceDao.class).getRecordByEmployeeIdAndDate(employeeId, date);
            if (record == null) {
                //没有上班打卡记录时不允许执行下班打卡操作
                result = 0;
            } else {
                if (record.getSignOutTime() == null) {
                    //执行下班打卡
                    result = sqlSession.getMapper(AttendanceDao.class).updateSingoutByAttendanceId(record.getId(), DateUtil.now());
                } else {
                    result = -2;
                }
            }
            sqlSession.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
                result = -1;
            }
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        return result;
    }

    @Override
    public void getAttendancesByPage(String name, String searchDate, Page pageObj) throws SQLException {
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            int totalCount = sqlSession.getMapper(AttendanceDao.class).getAttendancesCount(name, searchDate);
            pageObj.setTotalCount(totalCount);
            if (totalCount > 0) {
                if (pageObj.getCurrPageNo() > pageObj.getTotalPageCount()) {
                    pageObj.setCurrPageNo(pageObj.getTotalPageCount());
                }
                List<Attendance> attendanceList = sqlSession.getMapper(AttendanceDao.class).getAttendancesByPage(name, searchDate, pageObj.getCurrPageNo(), pageObj.getPageSize());
                pageObj.setAttendanceList(attendanceList);
            } else {
                pageObj.setCurrPageNo(0);
                pageObj.setAttendanceList(new ArrayList<Attendance>());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
}
