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
import bg.infosys.interns.mregister.ws.dto.CompanyDTO;
import bg.infosys.interns.mregister.ws.service.CompanyService;

@RestController
@RequestMapping(ControllerConfig.COMPANIES_URL)
public class CompanyController {
	private final CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CompanyDTO> getCompanies(){
		return companyService.findAll();
	}

	@GetMapping("/{companyId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CompanyDTO> getCompany(@PathVariable Long companyId) {
		CompanyDTO dto = companyService.findById(companyId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CompanyDTO> create(@RequestBody @Valid CompanyDTO company) {
		CompanyDTO newCompany = companyService.save(company);
		return ResponseEntity.status(201).body(newCompany);
	}

	@PutMapping("/{companyId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CompanyDTO> update(@PathVariable Long companyId, @RequestBody @Valid CompanyDTO company) {
		CompanyDTO updatedCompany = companyService.update(company, companyId);
		return ResponseEntity.status(200).body(updatedCompany);
	}

	@DeleteMapping("/{companyId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<CompanyDTO> delete(@PathVariable Long companyId) {
		companyService.deleteById(companyId);
	    return ResponseEntity.noContent().build();
	}
}
