package bg.infosys.interns.mregister.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.interns.mregister.core.dao.LocationDAO;
import bg.infosys.interns.mregister.core.entity.Location;
import bg.infosys.interns.mregister.ws.dto.LocationDTO;
import bg.infosys.interns.mregister.ws.dto.mapper.LocationMapper;

@Service
public class LocationService {
	private final LocationDAO locationDAO;
	private final LocationMapper locationMapper;
	
	public LocationService(LocationDAO locationDAO, LocationMapper locationMapper)
	{
		this.locationDAO = locationDAO;
		this.locationMapper = locationMapper;
	}

	public List<LocationDTO> findAll() {
		return locationDAO.findAll().stream()
								 .map(c -> locationMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public LocationDTO findById(Long locationId) {
		return locationMapper.toDto(locationDAO.findById(locationId));
	}

	@Transactional
	public LocationDTO save(LocationDTO location) {
		Location newLocation = locationDAO.saveOrUpdate(locationMapper.toEntity(location));
		return locationMapper.toDto(newLocation);
	}

	@Transactional
	public LocationDTO update(LocationDTO location, Long locationId) {
		Location updatedLocation = locationDAO.findById(locationId);

		location.setId(locationId);
		updatedLocation = locationDAO.saveOrUpdate(locationMapper.toEntity(location, updatedLocation));
		return locationMapper.toDto(updatedLocation);
	}

	@Transactional
	public void deleteById(Long locationId) {
		locationDAO.deleteById(locationId);
	}
	
	
}
