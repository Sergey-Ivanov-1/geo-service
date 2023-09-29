package guru.qa.geoservice.data.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "geo")
public class CountryEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private UUID id;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "C")
	private List<List<List<List<Double>>>> coordinate;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<List<List<List<Double>>>> getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(List<List<List<List<Double>>>> coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CountryEntity countryEntity = (CountryEntity) o;
		return Objects.equals(id, countryEntity.id) && Objects.equals(countryName, countryEntity.countryName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, countryName);
	}
}
