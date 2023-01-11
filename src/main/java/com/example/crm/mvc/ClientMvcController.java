package com.example.crm.mvc;

import com.example.crm.dao.Client;
import com.example.crm.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientMvcController {

    @Autowired
    private CrmService crmService;

    @GetMapping("clients")
    public String afficheClients(Model model){

        List<Client> clients = crmService.getClients();
        model.addAttribute("clients", clients);

        return "clients";
    }


    @GetMapping("clients/new")
    public String createClientForm(Model model) {

        Client client = new Client();
        model.addAttribute("client", client);
        return "create_client";

    }

    @PostMapping("clients")
    public String saveClient(@ModelAttribute("client") Client client) {
        crmService.createClient(client);
        return "redirect:/clients";
    }

    @GetMapping("clients/edit/{id}")
    public String editClientForm(@PathVariable Integer id, Model model) {
        model.addAttribute("client", crmService.getClientById(id));
        return "edit_client";
    }
}
