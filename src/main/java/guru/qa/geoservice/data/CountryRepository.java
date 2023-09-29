package guru.qa.geoservice.data;

import guru.qa.geoservice.data.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CountryRepository extends CrudRepository<CountryEntity, UUID> {

}
