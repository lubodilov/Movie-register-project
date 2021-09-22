package bg.infosys.interns.mregister.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.interns.mregister.core.dao.GenreDAO;
import bg.infosys.interns.mregister.core.entity.Genre;
import bg.infosys.interns.mregister.ws.dto.GenreDTO;
import bg.infosys.interns.mregister.ws.dto.mapper.GenreMapper;

@Service
public class GenreService {
	private final GenreDAO genreDAO;
	private final GenreMapper genreMapper; 
	
	public GenreService(GenreDAO genreDAO, GenreMapper genreMapper)
	{
		this.genreDAO = genreDAO;
		this.genreMapper = genreMapper;
	}
	
	public List<GenreDTO> findAll() {
		return genreDAO.findAll().stream()
								 .map(c -> genreMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public GenreDTO findById(Long genreId) {
		return genreMapper.toDto(genreDAO.findById(genreId));
	}

	@Transactional
	public GenreDTO save(GenreDTO genre) {
		Genre newGenre = genreDAO.saveOrUpdate(genreMapper.toEntity(genre));
		return genreMapper.toDto(newGenre);
	}
	
	@Transactional
	public GenreDTO update(GenreDTO genre, Long genreId) {
		Genre updatedGenre = genreDAO.findById(genreId);

		genre.setId(genreId);
		updatedGenre = genreDAO.saveOrUpdate(genreMapper.toEntity(genre, updatedGenre));
		return genreMapper.toDto(updatedGenre);
	}

	@Transactional
	public void deleteById(Long genreId) {
		genreDAO.deleteById(genreId);
	}
	

}
