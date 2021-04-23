package com.order.process.app;

import com.order.process.app.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@ComponentScan({"com.order.process.app.controllers"})
@EntityScan("com.order.process.app.entities")
@EnableJpaRepositories("com.order.process.app.repos")
@PropertySource("classpath:db-config.properties")
public class OrderProcessingWebServer {

    @Autowired
    protected OrderRepository orderRepository;
    protected Logger logger = Logger.getLogger(OrderProcessingWebServer.class.getName());

    public static void main(String[] args) {
        // Tell server to look for web-server.properties
        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(OrderProcessingWebServer.class, args);
    }
}
