package dev.juandavid.msscbrewery.business.service.customer;

import dev.juandavid.msscbrewery.model.dto.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

    void deleteById(UUID customerid);
}
