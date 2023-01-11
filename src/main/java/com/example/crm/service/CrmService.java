package com.example.crm.service;

import com.example.crm.dao.Client;
import com.example.crm.dao.ClientRepository;
import com.example.crm.dao.Order;
import com.example.crm.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrmService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OrderRepository orderRepository;

    // CREATE
    public void createClient(Client client){
        clientRepository.save(client);
    }

    public void createOrder(Order order){
        orderRepository.save(order);
    }

    // READ All List
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    // READ By Id
    /*public Client getClient(Integer id){
        return clientRepository.findById(id).get();
    }*/

    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    /*public Order getOrder(Integer id){
        return orderRepository.findById(id).get();
    }*/

    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    // DELETE
    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }

    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }

    // UPDATE
    public void updateClient(Integer id, Client client) {
        clientRepository.save(client);
    }

    public void updateOrder(Integer id, Order order) {
        orderRepository.save(order);
    }


}
