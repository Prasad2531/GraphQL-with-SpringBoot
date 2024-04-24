package com.example.demo.controller;

import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    private UserService userService;
    private OrderService orderService;
    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    //create order
    @MutationMapping
    public Order createOrder(@Argument String orderDetail,@Argument int price,@Argument int userId){
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setPrice(price);
        order.setUser(userService.getUserById(userId));
        return orderService.createOrder(order);
    }
    //update
    @MutationMapping
    public Order updateOrder(@Argument int orderId,@Argument String orderDetail,@Argument int price){
        Order order = orderService.getOrderById(orderId);
        order.setOrderDetail(orderDetail);
        order.setPrice(price);
        return orderService.updateOrder(order);

    }
    //delete
    @MutationMapping
    public Boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }
//    getOrder
    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrderById(orderId);
    }

    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }


}
