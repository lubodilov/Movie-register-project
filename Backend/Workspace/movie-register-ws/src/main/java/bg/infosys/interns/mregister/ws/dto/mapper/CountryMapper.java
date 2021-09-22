package bg.infosys.interns.mregister.ws.dto.mapper;

import org.springframework.stereotype.Component;
import bg.infosys.interns.mregister.core.entity.Country;
import bg.infosys.interns.mregister.ws.dto.CountryDTO;

@Component
public class CountryMapper implements IModelMapper<CountryDTO, Country> { 
	
	public CountryMapper() {}

	@Override
	public CountryDTO toDto(Country entity) {
		if (entity == null) return null;
		
		CountryDTO dto = new CountryDTO();
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		return dto;
	}
	
	@Override
	public Country toEntity(CountryDTO dto) {
		if (dto == null) return null;
		
		Country entity = new Country();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
	
	@Override
	public Country toEntity(CountryDTO dto, Country entity) {
		if (dto == null) return null;
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}

}