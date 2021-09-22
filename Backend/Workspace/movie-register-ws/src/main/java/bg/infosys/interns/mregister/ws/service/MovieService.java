package bg.infosys.interns.mregister.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.interns.mregister.core.dao.MovieDAO;
import bg.infosys.interns.mregister.core.entity.Movie;
import bg.infosys.interns.mregister.ws.dto.MovieDTO;
import bg.infosys.interns.mregister.ws.dto.mapper.MovieMapper;

@Service
public class MovieService {
	private final MovieDAO movieDAO;
	private final MovieMapper movieMapper;
	
	public MovieService(MovieDAO movieDAO, MovieMapper movieMapper)
	{
		this.movieDAO = movieDAO;
		this.movieMapper = movieMapper;
	}

	public List<MovieDTO> findAll() {
		return movieDAO.findAll().stream()
								 .map(c -> movieMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public MovieDTO findById(Long movieId) {
		return movieMapper.toDto(movieDAO.findById(movieId));
	}

	@Transactional
	public MovieDTO save(MovieDTO movie) {
		Movie newMovie = movieDAO.saveOrUpdate(movieMapper.toEntity(movie));
		return movieMapper.toDto(newMovie);
	}

	@Transactional
	public MovieDTO update(MovieDTO movie, Long movieId) {
		Movie updatedMovie = movieDAO.findById(movieId);

		movie.setId(movieId);
		updatedMovie = movieDAO.saveOrUpdate(movieMapper.toEntity(movie, updatedMovie));
		return movieMapper.toDto(updatedMovie);
	}

	@Transactional
	public void deleteById(Long movieId) {
		movieDAO.deleteById(movieId);
	}
	

}
