package dev.juandavid.msscbrewery.business.controller;

import dev.juandavid.msscbrewery.business.service.BeerService;
import dev.juandavid.msscbrewery.model.dto.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerservice;

    public BeerController(BeerService beerservice) {
        this.beerservice = beerservice;
    }

    @GetMapping("/{beerid}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerid") UUID beerid){
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }
}
