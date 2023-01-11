package com.example.crm.api;

import com.example.crm.dao.Client;
import com.example.crm.dao.Order;
import com.example.crm.service.CrmService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ClientController {

    @Autowired
    CrmService crmService;

    @PostMapping("clients")
    public void createClient(@RequestBody Client client){
        crmService.createClient(client);
    }

    @GetMapping("clients")
    public List<Client> getClients(){
        return crmService.getClients();
    }

    @GetMapping("clients/{id}")
    public ResponseEntity getOneClient(@PathVariable Integer id){
        Optional<Client> optional = crmService.getClientById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Client client = optional.get();
            return ResponseEntity.ok(client);
        }
    }

    @DeleteMapping("clients/{id}")
    public void deleteClient(@PathVariable Integer id){
        crmService.deleteClient(id);
    }

    @PutMapping("clients/{id}")
    public ResponseEntity updateClient(@PathVariable Integer id, @RequestBody Client client){
        if(id.equals(client.getId())){
            System.out.println(client.getId());
            crmService.updateClient(id, client);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /*@PutMapping("clients/{id}")
    public void updateClient(@PathVariable Integer id, @RequestBody Client client){
        crmService.updateClient(id, client);
    }*/



}
