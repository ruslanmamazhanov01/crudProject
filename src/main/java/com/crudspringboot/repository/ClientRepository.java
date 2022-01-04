package com.crudspringboot.repository;

import com.crudspringboot.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT u FROM Client u WHERE u.name = :name")
    Client findByUsername(String name);
}
