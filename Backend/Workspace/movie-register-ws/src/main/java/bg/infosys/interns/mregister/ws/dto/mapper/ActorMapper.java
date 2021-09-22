package bg.infosys.interns.mregister.ws.dto.mapper;

import org.springframework.stereotype.Component;
import bg.infosys.interns.mregister.core.entity.Actor;
//import bg.infosys.interns.mregister.core.entity.Location;
//import bg.infosys.interns.mregister.core.entity.Organization;
import bg.infosys.interns.mregister.ws.dto.ActorDTO;

@Component
public class ActorMapper implements IModelMapper<ActorDTO, Actor> {
	private final OrganizationMapper organizationMapper;	
	private final LocationMapper locationMapper;

	public ActorMapper(OrganizationMapper organizationMapper, LocationMapper locationMapper){
		this.organizationMapper = organizationMapper;
		this.locationMapper = locationMapper;
	}
	
	@Override
	public ActorDTO toDto(Actor entity) {
		if (entity == null) return null;
		
		ActorDTO dto = new ActorDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setIsActive(entity.getIsActive());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setLocation(locationMapper.toDto(entity.getLocation()));
		dto.setOrganization(organizationMapper.toDto(entity.getOrganization()));
		return dto;
	}
	
	@Override
	public Actor toEntity(ActorDTO dto) {
		if (dto == null) return null;
		
		Actor entity = new Actor();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setIsActive(dto.getIsActive());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setLocation(locationMapper.toEntity(dto.getLocation()));
		entity.setOrganization(organizationMapper.toEntity(dto.getOrganization()));
		return entity;
	}
	
	@Override
	public Actor toEntity(ActorDTO dto, Actor entity) {
		if (dto == null) return null;
		
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setIsActive(dto.getIsActive());
		entity.setDateOfBirth(dto.getDateOfBirth());
		//entity.setLocation(locationMapper.toEntity(dto.getLocation(), locationEntity));
		//entity.setOrganization(organizationMapper.toEntity(dto.getOrganization(), organizationEntity));
		return entity;
	}

}
