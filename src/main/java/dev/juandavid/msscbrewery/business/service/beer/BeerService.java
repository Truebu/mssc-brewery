package dev.juandavid.msscbrewery.business.service.beer;

import dev.juandavid.msscbrewery.model.dto.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
