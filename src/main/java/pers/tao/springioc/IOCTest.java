package pers.tao.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tao on 17-6-20.
 */
public class IOCTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloIOC helloIOC = (HelloIOC) context.getBean("helloIOC");
        helloIOC.getMsg();
    }
}
