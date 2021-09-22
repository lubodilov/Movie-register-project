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
import bg.infosys.interns.mregister.ws.dto.OrganizationDTO;
import bg.infosys.interns.mregister.ws.service.OrganizationService;

@RestController
@RequestMapping(ControllerConfig.ORGANIZATIONS_URL)
public class OrganizationController {
	private final OrganizationService organizationService;

	public OrganizationController(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<OrganizationDTO> getOrganiations(){
		return organizationService.findAll();
	}

	@GetMapping("/{organizationId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable Long organizationId) {
		OrganizationDTO dto = organizationService.findById(organizationId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<OrganizationDTO> create(@RequestBody @Valid OrganizationDTO organization) {
		OrganizationDTO newOrganization = organizationService.save(organization);
		return ResponseEntity.status(201).body(newOrganization);
	}

	@PutMapping("/{organizationId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<OrganizationDTO> update(@PathVariable Long organizationId, @RequestBody @Valid OrganizationDTO organization) {
		OrganizationDTO updatedOrganization = organizationService.update(organization, organizationId);
		return ResponseEntity.status(200).body(updatedOrganization);
	}

	@DeleteMapping("/{organizationId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<OrganizationDTO> delete(@PathVariable Long organizationId) {
		organizationService.deleteById(organizationId);
	    return ResponseEntity.noContent().build();
	}
}
