package dao.impl;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrinterTest extends TestCase {

    public void testPrint() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Printer printer = (Printer) context.getBean("printer");
        String content = "轻灵 轻灵的鼠标一点\n" +
                "神奇的世界出现\n" +
                "双手 把双手放在胸前\n" +
                "敲打出美丽的画卷\n" +
                "轻灵 轻灵的鼠标一点\n" +
                "神奇的世界出现\n" +
                "双手 把双手放在胸前\n" +
                "敲打出美丽的画卷\n" +
                "是谁让IT生活多彩绚烂\n" +
                "青鸟在我们身边\n" +
                "纵然是IT时代风云变幻\n" +
                "青鸟青鸟与我们相伴\n" +
                "飞旋吧青鸟\n" +
                "将知识在神州大地撒遍\n" +
                "飞旋吧青鸟\n" +
                "让教育改变我们的生活\n" +
                "是你帮助我们实现了心愿\n" +
                "又是你让我们的世界变成无限\n" +
                "制作：异类 本人来自S2T14班\n" +
                "把此歌献给 没听过此歌的师兄师妹们\n" +
                "轻灵 轻灵的鼠标一点\n" +
                "双手 把双手放在胸前\n" +
                "神奇的世界出现\n" +
                "敲打出美丽的画卷\n" +
                "是谁让IT生活多彩绚烂\n" +
                "青鸟在我们身边\n" +
                "纵然是IT时代风云变幻\n" +
                "青鸟 青鸟与我们相伴\n" +
                "飞旋吧青鸟\n" +
                "将知识在神州大地撒遍\n" +
                "飞旋吧青鸟\n" +
                "让教育改变我们的生活\n" +
                "是你帮助我们实现了心愿\n" +
                "又是你让我们的世界变成无限\n" +
                "飞旋吧青鸟\n" +
                "飞旋吧青鸟\n" +
                "将知识在神州大地撒遍\n" +
                "让教育改变我们的生活\n" +
                "是你帮助我们实现了心愿\n" +
                "又是你让我们的世界变成无限\n" +
                "因为有你，地更广阔天更蓝\n";
        printer.print(content);
    }
}