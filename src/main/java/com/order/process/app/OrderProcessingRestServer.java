package com.order.process.app;

import com.order.process.app.services.rest.controllers.OrderController;
import com.order.process.app.services.rest.webservices.OrderRestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableDiscoveryClient

@ComponentScan(useDefaultFilters = false)
@EntityScan("com.order.process.app.services.rest.models")
public class OrderProcessingRestServer {

    public static final String POS_TERMINALS_OR_OTHER_SERVICE_URL = "http://REST-SERVICE";

    public static void main(String[] args) {

        // Tell server to look for rest-server.properties
        System.setProperty("spring.config.name", "rest-server");
        SpringApplication.run(OrderProcessingRestServer.class, args);
    }

    /**
     * A customized RestTemplate that has the ribbon load balancer build in. Note
     * that prior to the "Brixton"
     *
     * @return
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public OrderRestService orderService() {
        return new OrderRestService(POS_TERMINALS_OR_OTHER_SERVICE_URL);
    }

    @Bean
    public OrderController orderController() {
        return new OrderController(orderService());
    }
}
