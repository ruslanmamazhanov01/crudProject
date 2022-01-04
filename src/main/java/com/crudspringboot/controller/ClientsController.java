package com.crudspringboot.controller;

import com.crudspringboot.model.Client;
import com.crudspringboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ClientsController {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientsController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/admin")
    public List<Client> list() {
        List<Client> clients = new ArrayList<>();
        for (Client u : clientRepository.findAll()) {
            Client client = new Client();
            client.setName(u.getName());
            client.setEmail(u.getEmail());
            client.setId(u.getId());
            clients.add(client);
        }

        return clients;
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public void createClient(@RequestBody Client client) {
        System.out.println(client.getEmail());
        System.out.println(client.getName());
        System.out.println(client);
        clientRepository.save(client);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        try {
            return new ResponseEntity<>(clientRepository.save(client), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}