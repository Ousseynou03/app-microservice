package org.sid.billingservice.controller;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.sid.billingservice.service.CustomerRestClient;
import org.sid.billingservice.service.ProductRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final ProductRestClient productRestClient;
    private final CustomerRestClient customerRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, ProductRestClient productRestClient, CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.productRestClient = productRestClient;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping(path = "/fullBill/{id}")
    public Bill bill(@PathVariable("id") Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(pi-> {
            pi.setProduct(productRestClient.findProductById(pi.getProductID()));
        });

        return bill;
    }
}
