package dev.juandavid.msscbrewery.business.service.customer;

import dev.juandavid.msscbrewery.model.dto.BeerDto;
import dev.juandavid.msscbrewery.model.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customName("Juan")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        //todo
    }

    @Override
    public void deleteById(UUID customerid) {
        //todo
    }
}