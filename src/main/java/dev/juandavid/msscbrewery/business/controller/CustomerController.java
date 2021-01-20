package dev.juandavid.msscbrewery.business.controller;

import dev.juandavid.msscbrewery.business.service.customer.CustomerService;
import dev.juandavid.msscbrewery.model.dto.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.PublicKey;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController extends GenericController{

    private final CustomerService customerservice;

    public CustomerController(CustomerService customerservice) {
        this.customerservice = customerservice;
    }

    @GetMapping("/{customerid}")
    public ResponseEntity<CustomerDto> getCustomer(@NotNull  @PathVariable("customerid") UUID customerid) {
        return new ResponseEntity<>(customerservice.getCustomerById(customerid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@NotNull @Valid @RequestBody CustomerDto customerDto) {
        CustomerDto saveDto = customerservice.saveNewCustomer(customerDto);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1/customer/" + saveDto.getId().toString());
        return new ResponseEntity(header, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity handleUpdate(@NotNull @Valid @RequestBody CustomerDto customerDto) {
        customerservice.updateCustomer(customerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@NotNull @PathVariable("customerid") UUID customerid) {

        customerservice.deleteById(customerid);
    }

}
