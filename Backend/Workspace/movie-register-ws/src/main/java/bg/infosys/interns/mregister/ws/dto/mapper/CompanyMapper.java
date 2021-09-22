package bg.infosys.interns.mregister.ws.dto.mapper;

import org.springframework.stereotype.Component;
import bg.infosys.interns.mregister.core.entity.Company;
//import bg.infosys.interns.mregister.core.entity.Location;
import bg.infosys.interns.mregister.ws.dto.CompanyDTO;

@Component
public class CompanyMapper implements IModelMapper<CompanyDTO, Company> { 
	private final LocationMapper locationMapper;

	public CompanyMapper(LocationMapper locationMapper) {
		this.locationMapper = locationMapper;
	}

	@Override
	public CompanyDTO toDto(Company entity) {
		if (entity == null) return null;
		
		CompanyDTO dto = new CompanyDTO();
		dto.setId(entity.getId());
		dto.setFoundation(entity.getFoundation());
		dto.setWebsite(entity.getWebsite());
		dto.setLocation(locationMapper.toDto(entity.getLocation()));
		return dto;
	}
	
	@Override
	public Company toEntity(CompanyDTO dto) {
		if (dto == null) return null;
		
		Company entity = new Company();
		entity.setId(dto.getId());
		dto.setFoundation(entity.getFoundation());
		dto.setWebsite(entity.getWebsite());
		entity.setLocation(locationMapper.toEntity(dto.getLocation()));
		return entity;
	}
	
	@Override
	public Company toEntity(CompanyDTO dto, Company entity) {
		if (dto == null) return null;
		
		entity.setId(dto.getId());
		entity.setFoundation(dto.getFoundation());
		entity.setWebsite(dto.getWebsite());
		//entity.setLocation(locationMapper.toEntity(dto.getLocation(), locationEntity));
		return entity;
	}

}