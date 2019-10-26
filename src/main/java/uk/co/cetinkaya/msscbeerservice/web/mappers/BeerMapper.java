package uk.co.cetinkaya.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;

import uk.co.cetinkaya.msscbeerservice.domain.Beer;
import uk.co.cetinkaya.msscbeerservice.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

	BeerDto beerToBeerDto(Beer beer);
	
	Beer beerDtoToBeer(BeerDto beerDto);
}
