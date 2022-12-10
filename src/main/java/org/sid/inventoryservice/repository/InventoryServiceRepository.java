package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.InventoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InventoryServiceRepository extends JpaRepository<InventoryService, Long> {
}
