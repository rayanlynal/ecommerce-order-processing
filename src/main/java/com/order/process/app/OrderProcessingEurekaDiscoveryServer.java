package com.order.process.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, //
        DataSourceAutoConfiguration.class})
@EnableEurekaServer
@ComponentScan(useDefaultFilters = false)
public class OrderProcessingEurekaDiscoveryServer {
    public static void main(String[] args) {
        // Tell server to look for discovery-server.properties
        System.setProperty("spring.config.name", "discovery-server");

        SpringApplication.run(OrderProcessingEurekaDiscoveryServer.class, args);
    }
}