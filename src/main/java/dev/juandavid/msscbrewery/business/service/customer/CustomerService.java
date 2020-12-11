package dev.juandavid.msscbrewery.business.service.customer;

import dev.juandavid.msscbrewery.model.dto.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomById(UUID customId);
}
