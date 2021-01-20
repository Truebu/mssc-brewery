package dev.juandavid.msscbrewery.business.controller;

import dev.juandavid.msscbrewery.business.service.beer.BeerService;
import dev.juandavid.msscbrewery.model.dto.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerservice;

    public BeerController(BeerService beerservice) {
        this.beerservice = beerservice;
    }

    @GetMapping("/{beerid}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerid") UUID beerid) {
        return new ResponseEntity<>(beerservice.getBeerById(beerid), HttpStatus.OK);
    }

    @PostMapping  //post new beer
    public ResponseEntity handlePost(@Valid @RequestBody BeerDto beerDto) {
        BeerDto saveDto = beerservice.saveNewBeer(beerDto);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1/beer/" + saveDto.getBeerid().toString());
        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("/{beerid}")
    public ResponseEntity handleUdate(@PathVariable("beerid") UUID beerid, @Valid @RequestBody BeerDto beerDto) {

        beerservice.updateBeer(beerid, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerid") UUID beerId) {
        beerservice.deleteById(beerId);
    }

}
