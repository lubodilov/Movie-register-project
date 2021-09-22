package bg.infosys.interns.mregister.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.interns.mregister.core.dao.AwardTypeDAO;
import bg.infosys.interns.mregister.core.entity.AwardType;
import bg.infosys.interns.mregister.ws.dto.AwardTypeDTO;
import bg.infosys.interns.mregister.ws.dto.mapper.AwardTypeMapper;

@Service
public class AwardTypeService {
	private final AwardTypeDAO awardTypeDAO;
	private final AwardTypeMapper awardTypeMapper; 
	
	public AwardTypeService(AwardTypeDAO awardTypeDAO, AwardTypeMapper awardTypeMapper)
	{
		this.awardTypeDAO = awardTypeDAO;
		this.awardTypeMapper = awardTypeMapper;
	}
	
	public List<AwardTypeDTO> findAll() {
		return awardTypeDAO.findAll().stream()
								 .map(c -> awardTypeMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public AwardTypeDTO findById(Long awardTypeId) {
		return awardTypeMapper.toDto(awardTypeDAO.findById(awardTypeId));
	}

	@Transactional
	public AwardTypeDTO save(AwardTypeDTO awardType) {
		AwardType newAwardType = awardTypeDAO.saveOrUpdate(awardTypeMapper.toEntity(awardType));
		return awardTypeMapper.toDto(newAwardType);
	}
	
	@Transactional
	public AwardTypeDTO update(AwardTypeDTO awardType, Long awardTypeId) {
		AwardType updatedAwardType = awardTypeDAO.findById(awardTypeId);

		awardType.setId(awardTypeId);
		updatedAwardType = awardTypeDAO.saveOrUpdate(awardTypeMapper.toEntity(awardType, updatedAwardType));
		return awardTypeMapper.toDto(updatedAwardType);
	}

	@Transactional
	public void deleteById(Long awardTypeId) {
		awardTypeDAO.deleteById(awardTypeId);
	}
	

	
}
