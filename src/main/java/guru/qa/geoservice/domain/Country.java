package guru.qa.geoservice.domain;

import guru.qa.geoservice.data.entity.CountryEntity;
import java.util.List;

public record Country(String countryName, String countryCode, List<List<List<List<Double>>>> coordinate) {

	public static Country fromEntity(CountryEntity entity){
		return new Country(entity.getCountryName(), entity.getCountryCode(), entity.getCoordinate());
	}
}
