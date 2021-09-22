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
import bg.infosys.interns.mregister.ws.dto.AwardDTO;
import bg.infosys.interns.mregister.ws.service.AwardService;

@RestController
@RequestMapping(ControllerConfig.AWARDS_URL)
public class AwardController {
	private final AwardService awardService;

	public AwardController(AwardService awardService) {
		this.awardService = awardService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<AwardDTO> getAwards(){
		return awardService.findAll();
	}

	@GetMapping("/{awardId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AwardDTO> getAward(@PathVariable Long awardId) {
		AwardDTO dto = awardService.findById(awardId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AwardDTO> create(@RequestBody @Valid AwardDTO award) {
		AwardDTO newAward = awardService.save(award);
		return ResponseEntity.status(201).body(newAward);
	}

	@PutMapping("/{awardId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AwardDTO> update(@PathVariable Long awardId, @RequestBody @Valid AwardDTO award) {
		AwardDTO updatedAward = awardService.update(award, awardId);
		return ResponseEntity.status(200).body(updatedAward);
	}

	@DeleteMapping("/{awardId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<AwardDTO> delete(@PathVariable Long awardId) {
		awardService.deleteById(awardId);
	    return ResponseEntity.noContent().build();
	}
}
