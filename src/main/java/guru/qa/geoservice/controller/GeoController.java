package guru.qa.geoservice.controller;

import guru.qa.geoservice.data.entity.CountryEntity;
import guru.qa.geoservice.domain.Country;
import guru.qa.geoservice.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeoController {

	private final GeoService geoService;

	@Autowired
	public GeoController(GeoService geoService) {
		this.geoService = geoService;
	}

	@GetMapping("/geo")
	public List<Country> getAllCountry(){
		return geoService.getAllCountry();
	}

	@PostMapping
	public ResponseEntity<Country> addCountry(@RequestBody Country country){
		CountryEntity countryEntity = geoService.addCountry(country);
		Country newCountry = new Country(countryEntity.getCountryName(), countryEntity.getCountryCode(), countryEntity.getCoordinate());
		return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
	}


	@PatchMapping(value = "/{countryCode}")
	public ResponseEntity<Country> patchCountry(@PathVariable String code, String name){
		try{
			CountryEntity countryEntity = geoService.editCountry(code, name);
			Country country = new Country(countryEntity.getCountryName(), countryEntity.getCountryCode(), countryEntity.getCoordinate());
			return new ResponseEntity<>(country, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}