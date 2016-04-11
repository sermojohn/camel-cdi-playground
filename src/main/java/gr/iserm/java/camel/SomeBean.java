package gr.iserm.java.camel;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.jms.ConnectionFactory;

@Singleton
@Named("counterBean")
public class SomeBean {

    @Resource(name = "java:jboss/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    private int counter;

    public String someMethod(String body) {
        return "Saying Hello World " + ++counter + " times";
    }

}
