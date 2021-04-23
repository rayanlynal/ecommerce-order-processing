package com.order.process.app.services.rest.controllers;

import com.order.process.app.services.rest.models.RestOrder;
import com.order.process.app.services.rest.webservices.OrderRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class OrderController {

    @Autowired
    protected OrderRestService orderRestService;

    protected Logger logger = Logger.getLogger(OrderController.class.getName());

    public OrderController(OrderRestService orderRestService) {
        this.orderRestService = orderRestService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("orderId", "searchText");
    }

    @RequestMapping("/orders/{orderId}")
    public String byOrderId(Model model, @PathVariable("orderId") String orderId) {

        logger.info("****rest-service byOrderId() invoked: " + orderId + " ****");

        RestOrder restOrder = orderRestService.byOrderId(orderId);
        logger.info("****rest-service byOrderId() found: " + restOrder.toString() + " ****");
        model.addAttribute("restOrder", restOrder);
        return "restOrder";
    }
}
