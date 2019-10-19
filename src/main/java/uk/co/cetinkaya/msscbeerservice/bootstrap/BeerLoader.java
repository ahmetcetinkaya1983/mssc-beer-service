package uk.co.cetinkaya.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import uk.co.cetinkaya.msscbeerservice.domain.Beer;
import uk.co.cetinkaya.msscbeerservice.repository.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner{

	private final BeerRepository beerRepository;

	public BeerLoader(BeerRepository beerRepository) {
		super();
		this.beerRepository = beerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		loadBeerObjects();
	}

	private void loadBeerObjects() {
		// TODO Auto-generated method stub
		if(beerRepository.count() == 0) {
			beerRepository.save(Beer.builder()
					.beerName("Mango Bobs")
					.beerStyle("IPA")
					.quentityToBrew(200)
					.minOnHand(12)
					.upc(337010000001L)
					.price(new BigDecimal("12.95"))
					.build());
			
			beerRepository.save(Beer.builder()
					.beerName("Galaxy Cat")
					.beerStyle("PALE_ALE")
					.quentityToBrew(300)
					.minOnHand(28)
					.upc(337010005001L)
					.price(new BigDecimal("10.99"))
					.build());
		}
		
		System.out.println("Loaded Beers: "+ beerRepository.count());
	}
	

}
