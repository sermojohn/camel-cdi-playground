package gr.iserm.java.camel;

import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.ConnectionFactory;

import static org.springframework.jms.listener.DefaultMessageListenerContainer.CACHE_NONE;

@ApplicationScoped
public class CamelContext extends DefaultCamelContext {

    @Resource(name = "java:jboss/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @PostConstruct
    public void init() {
        JmsComponent jmsComponent = (JmsComponent) getComponent("jms");
        jmsComponent.setConnectionFactory(connectionFactory);
        jmsComponent.setCacheLevel(CACHE_NONE);
    }


}
