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
import bg.infosys.interns.mregister.ws.dto.ActorDTO;
import bg.infosys.interns.mregister.ws.service.ActorService;

@RestController
@RequestMapping(ControllerConfig.ACTORS_URL)
public class ActorController {
	private final ActorService actorService;

	public ActorController(ActorService actorService) {
		this.actorService = actorService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ActorDTO> getActors(){
		return actorService.findAll();
	}

	@GetMapping("/{actorId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ActorDTO> getActor(@PathVariable Long actorId) {
		ActorDTO dto = actorService.findById(actorId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ActorDTO> create(@RequestBody @Valid ActorDTO actor) {
		ActorDTO newActor = actorService.save(actor);
		return ResponseEntity.status(201).body(newActor);
	}

	@PutMapping("/{actorId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ActorDTO> update(@PathVariable Long actorId, @RequestBody @Valid ActorDTO actor) {
		ActorDTO updatedActor = actorService.update(actor, actorId);
		return ResponseEntity.status(200).body(updatedActor);
	}

	@DeleteMapping("/{actorId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<ActorDTO> delete(@PathVariable Long actorId) {
		actorService.deleteById(actorId);
	    return ResponseEntity.noContent().build();
	}
}
