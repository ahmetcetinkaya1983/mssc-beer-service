package uk.co.cetinkaya.msscbeerservice.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uk.co.cetinkaya.msscbeerservice.domain.Beer;
import uk.co.cetinkaya.msscbeerservice.exceptions.NotFoundException;
import uk.co.cetinkaya.msscbeerservice.repository.BeerRepository;
import uk.co.cetinkaya.msscbeerservice.services.BeerService;
import uk.co.cetinkaya.msscbeerservice.web.mappers.BeerMapper;
import uk.co.cetinkaya.msscbeerservice.web.model.BeerDto;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
	
	private final BeerRepository beerRepository;
	private final BeerMapper beerMapper;

	@Override
	public BeerDto getById(UUID beerId) {
		// TODO Auto-generated method stub
		return beerMapper.beerToBeerDto(
				beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		// TODO Auto-generated method stub
		return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
		
		beer.setBeerName(beerDto.getBeerName());
		beer.setBeerStyle(beerDto.getBeerStyle().name());
		beer.setPrice(beerDto.getPrice());
		beer.setUpc(beerDto.getUpc());
		
		return beerMapper.beerToBeerDto(beerRepository.save(beer));
	}

}
