package bg.infosys.interns.mregister.ws.dto.mapper;

import org.springframework.stereotype.Component;

//import bg.infosys.interns.mregister.core.entity.Country;
import bg.infosys.interns.mregister.core.entity.Location;
import bg.infosys.interns.mregister.ws.dto.LocationDTO;

@Component
public class LocationMapper implements IModelMapper<LocationDTO, Location> { 
	private final CountryMapper countryMapper;

	public LocationMapper(CountryMapper countryMapper) {
		this.countryMapper=countryMapper;
	}

	@Override
	public LocationDTO toDto(Location entity) {
		if (entity == null) return null;
		
		LocationDTO dto = new LocationDTO();
		dto.setId(entity.getId());
		dto.setAddress(entity.getAddress());
		dto.setCountry(countryMapper.toDto(entity.getCountry()));
		return dto;
	}
	
	@Override
	public Location toEntity(LocationDTO dto) {
		if (dto == null) return null;
		
		Location entity = new Location ();
		entity.setId(dto.getId());
		entity.setAddress(dto.getAddress());
		entity.setCountry(countryMapper.toEntity(dto.getCountry()));
		return entity;
	}
	
	@Override
	public Location toEntity(LocationDTO dto, Location entity) {
		if (dto == null) return null;
		
		entity.setId(dto.getId());
		entity.setAddress(dto.getAddress());
		//entity.setCountry(countryMapper.toEntity(dto.getCountry(), countryEntity));
		return entity;
	}

}