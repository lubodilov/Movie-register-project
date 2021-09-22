package bg.infosys.interns.mregister.ws.dto.mapper;

import org.springframework.stereotype.Component;
import bg.infosys.interns.mregister.core.entity.Organization;
import bg.infosys.interns.mregister.ws.dto.OrganizationDTO;

@Component
public class OrganizationMapper implements IModelMapper<OrganizationDTO, Organization> { 
	private final LocationMapper locationMapper;
	
	public OrganizationMapper(LocationMapper locationMapper) {
		this.locationMapper=locationMapper;
	}
	
	@Override
	public OrganizationDTO toDto(Organization entity) {
		if (entity == null) return null;
		
		OrganizationDTO dto = new OrganizationDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAbbreviation(entity.getAbbreviation());
		dto.setFoundation(entity.getFoundation());
		dto.setLocation(locationMapper.toDto(entity.getLocation()));
		return dto;
	}
	
	@Override
	public Organization toEntity(OrganizationDTO dto) {
		if (dto == null) return null;
		
		Organization entity = new Organization ();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAbbreviation(dto.getAbbreviation());
		entity.setFoundation(dto.getFoundation());
		entity.setLocation(locationMapper.toEntity(dto.getLocation()));
		return entity;
	}
	
	@Override
	public Organization toEntity(OrganizationDTO dto, Organization entity) {
		if (dto == null) return null;
		
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAbbreviation(dto.getAbbreviation());
		entity.setFoundation(dto.getFoundation());
		//entity.setLocation(locationMapper.toEntity(dto.getLocation(), locationEntity));
		return entity;
	}

}
