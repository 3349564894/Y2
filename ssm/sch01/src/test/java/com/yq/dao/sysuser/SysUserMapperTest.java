package com.yq.dao.sysuser;

import com.yq.entity.SysUser;
import com.yq.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SysUserMapperTest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void count() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            int count = sqlSession.getMapper(SysUserMapper.class).count();
            logger.debug("SysUserMapperTest count ----> " + count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    @Test
    public void getUserList() {
        SqlSession sqlSession = null;
        List<SysUser> userList = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            userList = sqlSession.getMapper(SysUserMapper.class).getUserList();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        if (userList != null) {
            for (SysUser user : userList) {
                logger.debug("testUserListQuery account: " + user.getAccount() + "and realName:" + user.getRealName());
            }
        }
    }
}