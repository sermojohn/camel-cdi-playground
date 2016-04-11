package gr.iserm.java.camel;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.cdi.Uri;

/**
 * Configures all our Camel routes, components, endpoints and beans
 */
public class MyRoutes extends RouteBuilder {

    @Override
    public void configure() {
        // you can configure the route rule with Java DSL here

        from("jms:queue1?concurrentConsumers=5")
                .log("consumed message ${body}")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Thread.sleep(2000);
                    }
                })
        .to("jms:queue2");

        from("timer://foo?period=100&delay=1000")
             .bean("counterBean", "someMethod")
                .to("jms:queue1");

    }

}
