package org.sid.customer.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomerService", types = Customer.class)
public interface CustomerProjection extends Projection {
    public Long getId();
    public String getName();
    public String getEmail();
}
