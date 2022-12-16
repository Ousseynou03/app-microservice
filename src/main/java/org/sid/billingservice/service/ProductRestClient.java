package org.sid.billingservice.service;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    //Méthode qui récupére un produit sachant son id
    @GetMapping(path = "/products/{id}")
    public Product findProductById(@PathVariable Long id);

    @GetMapping(path = "/products")
    PagedModel<Product> allProduts();
}
