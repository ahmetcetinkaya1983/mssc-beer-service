package uk.co.cetinkaya.msscbeerservice.services;

import java.util.UUID;


import uk.co.cetinkaya.msscbeerservice.web.model.BeerDto;

public interface BeerService {

	BeerDto getById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

}
