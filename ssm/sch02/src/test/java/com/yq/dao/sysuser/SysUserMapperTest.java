package com.yq.dao.sysuser;

import com.yq.entity.Address;
import com.yq.entity.SysUser;
import com.yq.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SysUserMapperTest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

//    //查询用户信息
//    @Test
//    public void getUserByRealName() {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MyBatisUtil.createSqlSession();
//            List<SysUser> list = sqlSession.getMapper(SysUserMapper.class).getUserByRealName("李");
//            for (SysUser sysUser: list) {
//                System.out.println("-------------------------------------");
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getRealName());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getSex());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getAddress());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getBirthday());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getPhone());
//                System.out.println("-------------------------------------");
//            }
//        } finally {
//            MyBatisUtil.closeSqlSession(sqlSession);
//        }
//    }
//    @Test
//    public void getUserListByPojo() {
//        SqlSession sqlSession = null;
//        try {
//            SysUser user = new SysUser();
//            user.setRealName("李");
//            user.setRoleId(3);
//            sqlSession = MyBatisUtil.createSqlSession();
//            List<SysUser> list = sqlSession.getMapper(SysUserMapper.class).getUserListByPojo(user);
//            for (SysUser sysUser: list) {
//                System.out.println("-------------------------------------");
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getRealName());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getSex());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getAddress());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getBirthday());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getPhone());
//                System.out.println("-------------------------------------");
//            }
//        }finally {
//            MyBatisUtil.closeSqlSession(sqlSession);
//        }
//    }
//
//    @Test
//    public void getUserLisetByMap() {
//        SqlSession sqlSession = null;
//        try {
//            Map<String,Object> userMap = new HashMap<String, Object>();
//            userMap.put("realName","李");
//            userMap.put("roleId",3);
//            sqlSession = MyBatisUtil.createSqlSession();
//            List<SysUser> list = sqlSession.getMapper(SysUserMapper.class).getUserLisetByMap(userMap);
//            for (SysUser sysUser: list) {
//                System.out.println("-------------------------------------");
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getRealName());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getSex());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getAddress());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getBirthday());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getPhone());
//                System.out.println("-------------------------------------");
//            }
//        }finally {
//            MyBatisUtil.closeSqlSession(sqlSession);
//        }
//    }
//
//    @Test
//    public void getUserLisetByParams() {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MyBatisUtil.createSqlSession();
//            List<SysUser> list = sqlSession.getMapper(SysUserMapper.class).getUserLisetByParams("李",3);
//            for (SysUser sysUser: list) {
//                System.out.println("-------------------------------------");
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getRealName());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getSex());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getAddress());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getBirthday());
//                logger.debug("SysUserMapperTest getUserByRealName ----> " + sysUser.getPhone());
//                System.out.println("-------------------------------------");
//            }
//        }finally {
//            MyBatisUtil.closeSqlSession(sqlSession);
//        }
//    }

//    @Test
//    public void getUserListWithRoleName() {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MyBatisUtil.createSqlSession();
//            SysUser sysUser = new SysUser();
//            sysUser.setRealName("李");
//            sysUser.setRoleId(2);
//            List<SysUser> list = sqlSession.getMapper(SysUserMapper.class).getUserListWithRoleName(sysUser);
//            for (SysUser s: list) {
//                System.out.println("-------------------------------------");
//                System.out.println("-------------------------------------");
//                logger.debug("SysUserMapperTest 我在这里!!! 角色 ----> " + s.getUserRoleName());
//                logger.debug("SysUserMapperTest 我在这里!!! 供货商 ----> " + s.getSupplierName());
//                System.out.println("-------------------------------------");
//                System.out.println("-------------------------------------");
//            }
//        }finally {
//            MyBatisUtil.closeSqlSession(sqlSession);
//        }
//    }

//    @Test
//    public void getUserListByRoleId() {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MyBatisUtil.createSqlSession();
//            List<SysUser> list = sqlSession.getMapper(SysUserMapper.class).getUserListByRoleId(2);
//            for (SysUser s: list) {
//                System.out.println("-------------------------------------");
//                System.out.println("-------------------------------------");
//                logger.debug("SysUserMapperTest 我在这里!!! 姓名 ----> " + s.getRealName());
//                logger.debug("SysUserMapperTest 我在这里!!! 代码 ----> " + s.getSysRole().getCode());
//                logger.debug("SysUserMapperTest 我在这里!!! 角色 ----> " + s.getSysRole().getRoleName());
//                System.out.println("-------------------------------------");
//                System.out.println("-------------------------------------");
//            }
//        }finally {
//            MyBatisUtil.closeSqlSession(sqlSession);
//        }
//    }

    @Test
    public void getUserAndAddressesByUserId() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            List<SysUser> list = sqlSession.getMapper(SysUserMapper.class).getUserAndAddressesByUserId(1);
            if (list.size() == 0) {
                System.out.println("-------------------------------------");
                System.out.println("-------------------------------------");
                System.out.println("没有数据");
                System.out.println("-------------------------------------");
                System.out.println("-------------------------------------");
                return;
            } else
                for (SysUser s : list) {

                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                    logger.debug("SysUserMapperTest 我在这里!!! 用户姓名 ----> " + s.getRealName());
                    for (Address address : s.getAddressList()) {
                        logger.debug("SysUserMapperTest 我在这里!!! 联系人姓名 ----> " + address.getContact());
                        logger.debug("SysUserMapperTest 我在这里!!! 收货地址明细 ----> " + address.getAddressDesc());
                        logger.debug("SysUserMapperTest 我在这里!!! 联系人电话 ----> " + address.getTel());
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("-------------------------------------");
                }
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
}