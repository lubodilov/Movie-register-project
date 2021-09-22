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
import bg.infosys.interns.mregister.ws.dto.LocationDTO;
import bg.infosys.interns.mregister.ws.service.LocationService;

@RestController
@RequestMapping(ControllerConfig.LOCATIONS_URL)
public class LocationController {
	private final LocationService locationService;

	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<LocationDTO> getLocations(){
		return locationService.findAll();
	}

	@GetMapping("/{locationId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<LocationDTO> getLocation(@PathVariable Long locationId) {
		LocationDTO dto = locationService.findById(locationId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<LocationDTO> create(@RequestBody @Valid LocationDTO location) {
		LocationDTO newLocation = locationService.save(location);
		return ResponseEntity.status(201).body(newLocation);
	}

	@PutMapping("/{locationId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<LocationDTO> update(@PathVariable Long locationId, @RequestBody @Valid LocationDTO location) {
		LocationDTO updatedLocation = locationService.update(location, locationId);
		return ResponseEntity.status(200).body(updatedLocation);
	}

	@DeleteMapping("/{locationId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<LocationDTO> delete(@PathVariable Long locationId) {
		locationService.deleteById(locationId);
	    return ResponseEntity.noContent().build();
	}
}
