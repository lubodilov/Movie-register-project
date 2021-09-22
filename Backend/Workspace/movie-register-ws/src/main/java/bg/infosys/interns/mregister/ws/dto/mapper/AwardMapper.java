package bg.infosys.interns.mregister.ws.dto.mapper;

import org.springframework.stereotype.Component;
import bg.infosys.interns.mregister.core.entity.Award;
//import bg.infosys.interns.mregister.core.entity.AwardType;
//import bg.infosys.interns.mregister.core.entity.Organization;
import bg.infosys.interns.mregister.ws.dto.AwardDTO;

@Component
public class AwardMapper implements IModelMapper<AwardDTO, Award> { 
	private final OrganizationMapper organizationMapper;	
	private final AwardTypeMapper awardTypeMapper;

	public AwardMapper(OrganizationMapper organizationMapper, AwardTypeMapper awardTypeMapper) {
		this.organizationMapper = organizationMapper;
		this.awardTypeMapper = awardTypeMapper;
	}
	
	@Override
	public AwardDTO toDto(Award entity) {
		if (entity == null) return null;
		
		AwardDTO dto = new AwardDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setIsActive(entity.getIsActive());
		dto.setFoundation(entity.getFoundation());
		dto.setAwardType(awardTypeMapper.toDto(entity.getAwardType()));
		dto.setOrganization(organizationMapper.toDto(entity.getOrganization()));
		//dto.setAwardParent(this.toDto(entity.getAwardParent())); Тук незнам точно как да го направя за да не се получи рекурсия!
		return dto;
	}
	
	@Override
	public Award toEntity(AwardDTO dto) {
		if (dto == null) return null;
		
		Award entity = new Award();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setIsActive(dto.getIsActive());
		entity.setFoundation(dto.getFoundation());
		entity.setAwardType(awardTypeMapper.toEntity(dto.getAwardType()));
		entity.setOrganization(organizationMapper.toEntity(dto.getOrganization()));
		//entity.setAwardChild(this.toEntity(dto.getAwardChild()));
		return entity;
	}
	
	
	@Override
	public Award toEntity(AwardDTO dto, Award entity) {
		if (dto == null) return null;
		
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setIsActive(dto.getIsActive());
		entity.setFoundation(dto.getFoundation());
		//entity.setAwardType(awardTypeMapper.toEntity(dto.getAwardType(), awardTypeEntity));
		//entity.setOrganization(organizationMapper.toEntity(dto.getOrganization(), organizationEntity));
		//entity.setAwardChild(this.toEntity(dto.getAwardChild(), entity));
		return entity;
	}

}
