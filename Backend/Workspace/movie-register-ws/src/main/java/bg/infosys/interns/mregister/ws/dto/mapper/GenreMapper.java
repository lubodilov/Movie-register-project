package bg.infosys.interns.mregister.ws.dto.mapper;

import org.springframework.stereotype.Component;
import bg.infosys.interns.mregister.core.entity.Genre;
import bg.infosys.interns.mregister.ws.dto.GenreDTO;

@Component
public class GenreMapper implements IModelMapper<GenreDTO, Genre> { 
	
	public GenreMapper() {}
	
	@Override
	public GenreDTO toDto(Genre entity) {
		if (entity == null) return null;
		
		GenreDTO dto = new GenreDTO();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		return dto;
	}
	
	@Override
	public Genre toEntity(GenreDTO dto) {
		if (dto == null) return null;
		
		Genre entity = new Genre();
		entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		return entity;
	}
	
	@Override
	public Genre toEntity(GenreDTO dto, Genre entity) {
		if (dto == null) return null;
		
		entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		return entity;
	}

}