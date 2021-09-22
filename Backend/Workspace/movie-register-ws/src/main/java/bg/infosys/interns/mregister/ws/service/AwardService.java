package bg.infosys.interns.mregister.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.interns.mregister.core.dao.AwardDAO;
import bg.infosys.interns.mregister.core.entity.Award;
import bg.infosys.interns.mregister.ws.dto.AwardDTO;
import bg.infosys.interns.mregister.ws.dto.mapper.AwardMapper;

@Service
public class AwardService {
	private final AwardDAO awardDAO;
	private final AwardMapper awardMapper;
	
	public AwardService(AwardDAO awardDAO, AwardMapper awardMapper)
	{
		this.awardDAO = awardDAO;
		this.awardMapper = awardMapper;
	}

	public List<AwardDTO> findAll() {
		return awardDAO.findAll().stream()
								 .map(c -> awardMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public AwardDTO findById(Long awardId) {
		return awardMapper.toDto(awardDAO.findById(awardId));
	}

	@Transactional
	public AwardDTO save(AwardDTO award) {
		Award newAward = awardDAO.saveOrUpdate(awardMapper.toEntity(award));
		return awardMapper.toDto(newAward);
	}

	@Transactional
	public AwardDTO update(AwardDTO award, Long awardId) {
		Award updatedAward = awardDAO.findById(awardId);

		award.setId(awardId);
		updatedAward = awardDAO.saveOrUpdate(awardMapper.toEntity(award, updatedAward));
		return awardMapper.toDto(updatedAward);
	}

	@Transactional
	public void deleteById(Long awardId) {
		awardDAO.deleteById(awardId);
	}
	

}
