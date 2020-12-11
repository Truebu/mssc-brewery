package dev.juandavid.msscbrewery.business.service.customer;

import dev.juandavid.msscbrewery.model.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomById(UUID customId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customName("Juan")
                .build();
    }
}