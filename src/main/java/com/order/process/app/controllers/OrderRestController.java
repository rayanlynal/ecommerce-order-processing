package com.order.process.app.controllers;

import com.order.process.app.entities.Order;
import com.order.process.app.exceptions.OrderNotFoundException;
import com.order.process.app.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class OrderRestController {

    protected Logger logger = Logger.getLogger(OrderRestController.class.getName());

    protected OrderRepository orderRepository;

    @Autowired
    public OrderRestController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        logger.info("****Order Management****");
        logger.info("****Total " + orderRepository.count() + " orders received ****");
    }

    @RequestMapping("/order/{orderId}")
    public Optional<Order> byOrderId(@PathVariable("orderId") String orderId) {
        logger.info("****Web-Service byOrderId() invoked :" + orderId + " ****");
        Optional<Order> order = orderRepository.findById(orderId);
        logger.info("****Web-Service byOrderId() found :" + order + " ****");
        if (order == null)
            throw new OrderNotFoundException(orderId);
        else {
            return order;
        }
    }

    @PostMapping(value = "/createorder")
    public Order createNewOrder(@RequestBody Order order) {
        logger.info("****web-service createNewOrder() invoked *****");
        Order orderCreated = orderRepository.save(order);
        if (orderCreated == null) {
            throw new OrderNotFoundException("Error");
        } else {
            logger.info("****web-service New Order is created *****");
            return orderCreated;
        }
    }

    @DeleteMapping("/cancelorder/{id}")
    public void cancelOrder(@PathVariable String id) {
        try {
            orderRepository.deleteById(id);
            logger.info("****web-service :: ORDER_ID " + id + " has been canceled! *****");
        } catch (Exception e) {
            logger.info("****web-service :: No order found with ORDER_ID " + id + "! *****");
            e.getMessage();
        }

    }
}
