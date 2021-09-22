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
import bg.infosys.interns.mregister.ws.dto.GenreDTO;
import bg.infosys.interns.mregister.ws.service.GenreService;

@RestController
@RequestMapping(ControllerConfig.GENRES_URL)
public class GenreController {
	private final GenreService genreService;
	
	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<GenreDTO> getGenres() {
		return genreService.findAll();
	}

	@GetMapping("/{genreId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<GenreDTO> getGenre(@PathVariable Long genreId) {
		GenreDTO dto = genreService.findById(genreId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<GenreDTO> create(@RequestBody @Valid GenreDTO genre) {
		GenreDTO newGenre = genreService.save(genre);
		return ResponseEntity.status(201).body(newGenre);
	}

	@PutMapping("/{genreId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<GenreDTO> update(@PathVariable Long genreId, @RequestBody @Valid GenreDTO Genre) {
		GenreDTO updatedGenre = genreService.update(Genre, genreId);
		return ResponseEntity.status(200).body(updatedGenre);
	}

	@DeleteMapping("/{genreId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<GenreDTO> delete(@PathVariable Long genreId) {
		genreService.deleteById(genreId);
	    return ResponseEntity.noContent().build();
	}
}
