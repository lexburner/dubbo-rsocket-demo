package moe.cnkirito.demo.rsocket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author daofeng.xjf
 */
public class RoscketServer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/rsocket-provider.xml"});
        context.start();
        System.in.read(); // press any key to exit
    }

}
