package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.InventoryService;
import org.sid.inventoryservice.repository.InventoryServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InventoryServiceRepository inventoryServiceRepository, RepositoryRestConfiguration restConfiguration){

        restConfiguration.exposeIdsFor(InventoryService.class);
        return args -> {

            inventoryServiceRepository.save(new InventoryService(null,"Computer Desk Top HP",900));
            inventoryServiceRepository.save(new InventoryService(null,"Printer Epson",80));
            inventoryServiceRepository.save(new InventoryService(null,"MacBook Pro Lap Top",1800));
            inventoryServiceRepository.findAll().forEach(System.out::println);

        };

    }

}
