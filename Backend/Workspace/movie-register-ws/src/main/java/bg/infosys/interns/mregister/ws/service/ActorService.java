package bg.infosys.interns.mregister.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.interns.mregister.core.dao.ActorDAO;
import bg.infosys.interns.mregister.core.entity.Actor;
import bg.infosys.interns.mregister.ws.dto.ActorDTO;
import bg.infosys.interns.mregister.ws.dto.mapper.ActorMapper;

@Service
public class ActorService {
	private final ActorDAO actorDAO;
	private final ActorMapper actorMapper;

	public ActorService(ActorDAO actorDAO, ActorMapper actorMapper) {
		this.actorDAO = actorDAO;
		this.actorMapper = actorMapper;
	}
	
	public List<ActorDTO> findAll() {
		return actorDAO.findAll().stream()
								 .map(c -> actorMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public ActorDTO findById(Long actorId) {
		return actorMapper.toDto(actorDAO.findById(actorId));
	}

	@Transactional
	public ActorDTO save(ActorDTO actor) {
		Actor newActor = actorDAO.saveOrUpdate(actorMapper.toEntity(actor));
		return actorMapper.toDto(newActor);
	}

	@Transactional
	public ActorDTO update(ActorDTO actor, Long actorId) {
		Actor updatedActor = actorDAO.findById(actorId);

		actor.setId(actorId);
		updatedActor = actorDAO.saveOrUpdate(actorMapper.toEntity(actor, updatedActor));
		return actorMapper.toDto(updatedActor);
	}

	@Transactional
	public void deleteById(Long actorId) {
		actorDAO.deleteById(actorId);
	}

}
