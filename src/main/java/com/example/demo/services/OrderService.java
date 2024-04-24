package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo=orderRepo;
    }

    //create order
    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    //getAll
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }
    //get Order
    public Order getOrderById(int id){
        Order order = orderRepo.findById(id).orElseThrow(()->new RuntimeException("Order not found!!"));
        return order;
    }

    public Order updateOrder(Order order){
        if(order==null || order.getOrderId()==null){
            return null;
        }
        else{
           Order savedOrder = orderRepo.save(order);
            return savedOrder;
        }
    }

    //delete Order
    public boolean deleteOrder(int id){
        Order order = orderRepo.findById(id).orElseThrow(()->new RuntimeException("Order not found!!"));
        orderRepo.delete(order);
        return true;
    }

}
