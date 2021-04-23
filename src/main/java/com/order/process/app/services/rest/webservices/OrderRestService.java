package com.order.process.app.services.rest.webservices;

import com.order.process.app.services.rest.models.RestOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Service
public class OrderRestService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;
    protected String serviceUrl;
    protected Logger logger = java.util.logging.Logger.getLogger(OrderRestService.class.getName());

    public OrderRestService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
        logger.info("****serviceUrl " + this.serviceUrl + " ****");
    }

    /**
     * The RestTemplate works because it uses a custom request-factory that uses
     * Ribbon to look-up the service to use. This method simply exists to show this.
     */
    @PostConstruct
    public void demoOnly() {
        // Can't do this in the constructor because the RestTemplate injection
        // happens afterwards.
        logger.warning("The RestTemplate request factory is " + restTemplate.getRequestFactory().getClass());
    }

    public RestOrder byOrderId(String orderId) {
        logger.info("****byOrderId() invoked: for id " + orderId + " ****");
        return restTemplate.getForObject(serviceUrl + "/orders/{orderId}", RestOrder.class, orderId);
    }

}
