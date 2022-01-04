package com.crudspringboot;

import com.crudspringboot.model.Client;
import com.crudspringboot.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PeaksostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeaksostApplication.class, args);
    }
//    @Bean
//    CommandLineRunner initDatabase(ClientRepository personRepository) {
//        return args -> {
//            personRepository.save(new Client("admin", "admin@gmail.com"));
////            personRepository.save(new Client("ruslan", "ruslan@ma.a"));
//            personRepository.save(new Client("Ayzhan", "hefasdllo@.gmail.ags"));
//            personRepository.save(new Client("Almaz", "hello@afjsdl"));


}
