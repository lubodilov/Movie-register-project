package bg.infosys.interns.mregister.ws.dto.mapper;

import org.springframework.stereotype.Component;
import bg.infosys.interns.mregister.core.entity.AwardType;
import bg.infosys.interns.mregister.ws.dto.AwardTypeDTO;

@Component
public class AwardTypeMapper implements IModelMapper<AwardTypeDTO, AwardType> { 
	
	public AwardTypeMapper() {}

	@Override
	public AwardTypeDTO toDto(AwardType entity) {
		if (entity == null) return null;
		
		AwardTypeDTO dto = new AwardTypeDTO();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		return dto;
	}


	@Override
	public AwardType toEntity(AwardTypeDTO dto) {
		if (dto == null) return null;
		
		AwardType entity = new AwardType();
		entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		return entity;
	}
	
	@Override
	public AwardType toEntity(AwardTypeDTO dto, AwardType entity) {
		if (dto == null) return null;
		
		entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		return entity;
	}

}