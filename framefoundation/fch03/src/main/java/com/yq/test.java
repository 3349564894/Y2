package com.yq;

import com.yq.dao.*;
import com.yq.dao.impl.*;
import com.yq.service.impl.NewsServiceImpl;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class test {
    NewsDao dao = SimpleDaoFactory.getInstance("mysql");
    NewsServiceImpl service = new NewsServiceImpl();
    AbstractFactory factory = new MySqlDaoFactory();
    NewsDao newsDao = factory.getInstance();
    NewsServiceImpl service1 = new NewsServiceImpl();
    Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void test1() {
        service.setDao(dao);
        System.out.println("类型:  " + dao.getClass().getName()); //查看类型
    }

    @Test
    public void test2() {
        service.setDao(newsDao);
        System.out.println(service.getDao());
    }

    //计算器
    @Test
    public void test3() {
//        Scanner in = new Scanner(System.in);
//        System.out.print("请输入您需要的运算符(+,-,*,/):");
//        String c = in.next();
//        CalculatorDao calculatorDao = CalculatorDaoFactory.getInstance('+'); //根据提供的运算符号给予不同的实例
//        System.out.println("请输入两位计算数:");
//        double d = in.nextDouble();
//        double d1 = in.nextDouble();
//        double js = calculatorDao.jisuan(10,20);
//        System.out.print("运算结果为:"+(int)js);
    }

    @Test
    public void test4() {
        CalculatorDaoFactory dao = new ChenDaoFactory();
        CalculatorDao dao1 = dao.getInstance();
        System.out.println("运算结果为:" + dao1.jisuan(100, 200));
    }

    @Test
    public void test5() {
        Buyer buyer = new IntermediaryImpl(new RealBuyer());
        String result = buyer.havealook();
        Logger logger = Logger.getLogger(this.getClass());
        logger.debug(result);
    }

    @Test
    public void test6() {
        Buyer buyer = IntermediaryInvocationHandler.create(new RealBuyer());
        String result = buyer.havealook();
        logger.debug(result);
    }

    @Test
    public void test7() {
        RealBuyer realBuyer = IntermediaryCglibProxyFactory.create(RealBuyer.class);
        String result = realBuyer.havealook();
        logger.debug(result);
    }
}
