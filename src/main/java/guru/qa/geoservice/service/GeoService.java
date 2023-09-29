package guru.qa.geoservice.service;

import guru.qa.geoservice.data.CountryRepository;
import guru.qa.geoservice.data.entity.CountryEntity;
import guru.qa.geoservice.domain.Country;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GeoService {

	private final CountryRepository countryRepository;

	@Autowired
	public GeoService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public List<Country> getAllCountry() {
		return IteratorUtils.toList(countryRepository.findAll().iterator())
				.stream()
				.map(Country::fromEntity)
				.toList();
	}

	public Optional<CountryEntity> getCountryByCode(String code) {
		return IteratorUtils.toList(countryRepository.findAll().iterator())
				.stream()
				.filter(country -> country.getCountryCode().equals(code))
				.findFirst();
	}

	@Transactional
	public CountryEntity addCountry(Country country) {
		CountryEntity countryEntity = new CountryEntity();
		countryEntity.setCountryName(country.countryName());
		countryEntity.setCountryCode(country.countryCode());
		countryEntity.setCoordinate(country.coordinate());
		return countryRepository.save(countryEntity);
	}

	@Transactional
	public CountryEntity editCountry(String code, String name) {
		Optional<CountryEntity> countryEntity = getCountryByCode(code);
		if (countryEntity.isPresent()){
			CountryEntity country = new CountryEntity();
			country.setCountryName(name);
			country.setCountryCode(code);
			country.setCoordinate(countryEntity.get().getCoordinate());
			return countryRepository.save(country);
		}
		throw new RuntimeException(String.format("Country code %s is not exist", code));
	}
}
