package dao;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class dialogueTest extends TestCase {

    public void testLfPrint() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        dialogue d = (dialogue) context.getBean("dialogue");
        d.lfPrint();
    }

    public void testZglPrint() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        dialogue d = (dialogue) context.getBean("dialogue");
        d.zglPrint();
    }
}