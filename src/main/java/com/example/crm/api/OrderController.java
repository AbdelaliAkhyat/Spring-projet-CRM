package com.example.crm.api;

import com.example.crm.dao.Client;
import com.example.crm.dao.Order;
import com.example.crm.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    CrmService crmService;

    @PostMapping("orders")
    public void createOrder(@RequestBody Order order){
        crmService.createOrder(order);
    }

    @GetMapping("orders")
    public List<Order> getOrders(){
        return crmService.getOrders();
    }

    @GetMapping("orders/{id}")
    public ResponseEntity getOneOrder(@PathVariable Integer id){
        Optional<Order> optional = crmService.getOrderById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Order order = optional.get();
            return ResponseEntity.ok(order);
        }
    }

    @DeleteMapping("orders/{id}")
    public void deleteOrder(@PathVariable Integer id){
        crmService.deleteOrder(id);
    }

    @PutMapping("orders/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @RequestBody Order order){
        if(id.equals(order.getId())){
            crmService.updateOrder(id, order);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@PutMapping("orders/{id}")
    public void updateOrder(@PathVariable Integer id, @RequestBody Order order){
        crmService.updateOrder(id, order);
    }*/
}
