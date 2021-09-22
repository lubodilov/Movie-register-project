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
import bg.infosys.interns.mregister.ws.dto.AwardTypeDTO;
import bg.infosys.interns.mregister.ws.service.AwardTypeService;

@RestController
@RequestMapping(ControllerConfig.AWARDS_TYPE_URL)
public class AwardTypeController {
	private final AwardTypeService awardTypeService;

	public AwardTypeController(AwardTypeService awardTypeService) {
		this.awardTypeService = awardTypeService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<AwardTypeDTO> getAwardsType(){
		return awardTypeService.findAll();
	}

	@GetMapping("/{awardTypeId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AwardTypeDTO> getAwardType(@PathVariable Long awardTypeId) {
		AwardTypeDTO dto = awardTypeService.findById(awardTypeId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AwardTypeDTO> create(@RequestBody @Valid AwardTypeDTO awardType) {
		AwardTypeDTO newAwardType = awardTypeService.save(awardType);
		return ResponseEntity.status(201).body(newAwardType);
	}

	@PutMapping("/{awardTypeId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AwardTypeDTO> update(@PathVariable Long awardTypeId, @RequestBody @Valid AwardTypeDTO awardType) {
		AwardTypeDTO updatedAwardType = awardTypeService.update(awardType, awardTypeId);
		return ResponseEntity.status(200).body(updatedAwardType);
	}

	@DeleteMapping("/{awardTypeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<AwardTypeDTO> delete(@PathVariable Long awardTypeId) {
		awardTypeService.deleteById(awardTypeId);
	    return ResponseEntity.noContent().build();
	}
}
