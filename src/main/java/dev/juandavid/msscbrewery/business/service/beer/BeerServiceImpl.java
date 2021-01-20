package dev.juandavid.msscbrewery.business.service.beer;

import dev.juandavid.msscbrewery.business.service.beer.BeerService;
import dev.juandavid.msscbrewery.model.dto.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .beerid(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .beerid(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerid, BeerDto beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {
        //todo
    }
}
