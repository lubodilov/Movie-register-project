package bg.infosys.interns.mregister.ws.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bg.infosys.interns.mregister.core.paging.CountryFilter;
import bg.infosys.interns.mregister.core.paging.PagingSorting;
import bg.infosys.interns.mregister.ws.config.ControllerConfig;
import bg.infosys.interns.mregister.ws.dto.CountryDTO;
import bg.infosys.interns.mregister.ws.dto.Page;
import bg.infosys.interns.mregister.ws.service.CountryService;

@RestController
@RequestMapping(ControllerConfig.COUNTRIES_URL)
public class CountryController {
	private final CountryService countryService;

	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@CrossOrigin("*")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CountryDTO> getCountries(){
		return countryService.findAll();
	}
	
	@CrossOrigin("*")
	@GetMapping("/paging")
	@ResponseStatus(HttpStatus.OK)
	public Page<CountryDTO> getCountriesPaging(
			@RequestParam(defaultValue = "1") int page,
	        @RequestParam(defaultValue = "5") int size,
	        @RequestParam(defaultValue = "name", required = false) String sortBy,
	        @RequestParam(defaultValue = "asc", required = false) String sortDirection,
	        @RequestParam(required = false) String code,
	        @RequestParam(required = false) String name){
		return countryService.findAllByFilter(new CountryFilter(code, name), new PagingSorting(page - 1, size, sortBy, sortDirection));
	}


	@CrossOrigin("*")
	@GetMapping("/{countryCode}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CountryDTO> getCountry(@PathVariable String countryCode) {
		CountryDTO dto = countryService.findByCode(countryCode);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}

	@CrossOrigin("*")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CountryDTO> create(@RequestBody @Valid CountryDTO country) {
		CountryDTO newCountry = countryService.save(country);
		return ResponseEntity.status(201).body(newCountry);
	}

	@CrossOrigin("*")
	@PutMapping("/{countryCode}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CountryDTO> update(@PathVariable String countryCode, @RequestBody @Valid CountryDTO country) {
		CountryDTO updatedcountry = countryService.update(country, countryCode);
		return ResponseEntity.status(200).body(updatedcountry);
	}

	@CrossOrigin("*")
	@DeleteMapping("/{countryCode}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<CountryDTO> delete(@PathVariable String countryCode) {
		countryService.deleteByCode(countryCode);
	    return ResponseEntity.noContent().build();
	}
}
