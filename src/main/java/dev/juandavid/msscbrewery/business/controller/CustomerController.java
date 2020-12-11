package dev.juandavid.msscbrewery.business.controller;

import dev.juandavid.msscbrewery.business.service.customer.CustomerService;
import dev.juandavid.msscbrewery.model.dto.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/custom")
public class CustomerController {

    private final CustomerService customerservice;

    public CustomerController(CustomerService customerservice) {
        this.customerservice = customerservice;
    }

    @GetMapping("/{customid}")
    public ResponseEntity<CustomerDto> getCustom(@PathVariable("customid") UUID customid){
        return new ResponseEntity<>(customerservice.getCustomById(customid), HttpStatus.OK);
    }
}
