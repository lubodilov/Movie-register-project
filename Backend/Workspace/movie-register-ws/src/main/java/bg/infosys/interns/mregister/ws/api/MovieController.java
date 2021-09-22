package bg.infosys.interns.mregister.ws.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bg.infosys.interns.mregister.ws.config.ControllerConfig;
import bg.infosys.interns.mregister.ws.dto.MovieDTO;
import bg.infosys.interns.mregister.ws.service.MovieService;

@RestController
@RequestMapping(ControllerConfig.MOVIES_URL)
public class MovieController {
	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<MovieDTO> getMovies(){
		return movieService.findAll();
	}

	@GetMapping("/{movieId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<MovieDTO> getMovie(@PathVariable Long movieId) {
		MovieDTO dto = movieService.findById(movieId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<MovieDTO> create(@RequestBody @Valid MovieDTO movie) {
		MovieDTO newMovie = movieService.save(movie);
		return ResponseEntity.status(201).body(newMovie);
	}

	@PutMapping("/{movieId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<MovieDTO> update(@RequestBody @Valid MovieDTO movie, @PathVariable Long movieId) {
		MovieDTO updatedMovie = movieService.update(movie, movieId);
		return ResponseEntity.status(200).body(updatedMovie);
	}

	@DeleteMapping("/{movieId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<MovieDTO> delete(@PathVariable Long movieId) {
		movieService.deleteById(movieId);
	    return ResponseEntity.noContent().build();
	}
}
