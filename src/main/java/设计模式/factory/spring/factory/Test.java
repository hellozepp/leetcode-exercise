package 设计模式.factory.spring.factory;

import java.io.IOException;

public class Test {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        BeanFactory f = new ClassPathXmlApplicationContext("com/bjsxt/spring/factory/applicationContext.xml");
        Object o = f.getBean("v");
        Moveable m = (Moveable) o;
        m.run();
    }

}
