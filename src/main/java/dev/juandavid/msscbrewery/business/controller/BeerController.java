package dev.juandavid.msscbrewery.business.controller;

import dev.juandavid.msscbrewery.business.service.beer.BeerService;
import dev.juandavid.msscbrewery.model.dto.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(beerservice.getBeerById(beerid), HttpStatus.OK);
    }

    @PostMapping  //post new beer
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto){
        BeerDto saveDto= beerservice.saveNewBeer(beerDto);
        HttpHeaders header = new HttpHeaders();
        header.add("Location","/api/v1/beer/"+saveDto.getId().toString());
        return new ResponseEntity(header,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity handleUdate(@RequestBody BeerDto beerDto){

        beerservice.updateBeer(beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerservice.deleteById(beerId);
    }

}
