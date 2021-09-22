package bg.infosys.interns.mregister.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.interns.mregister.core.dao.CountryDAO;
import bg.infosys.interns.mregister.core.entity.Country;
import bg.infosys.interns.mregister.core.paging.CountryFilter;
import bg.infosys.interns.mregister.core.paging.PagingSorting;
import bg.infosys.interns.mregister.ws.dto.CountryDTO;
import bg.infosys.interns.mregister.ws.dto.Page;
import bg.infosys.interns.mregister.ws.dto.mapper.CountryMapper;

@Service
public class CountryService {
	private final CountryDAO countryDAO;
	private final CountryMapper countryMapper;
	
	public CountryService(CountryDAO countryDAO, CountryMapper countryMapper)
	{
		this.countryDAO = countryDAO;
		this.countryMapper = countryMapper;
	}

	public List<CountryDTO> findAll() {
		return countryDAO.findAll().stream()
								 .map(c -> countryMapper.toDto(c))
								 .collect(Collectors.toList());
	}
		
	public Page<CountryDTO> findAllByFilter(CountryFilter filter, PagingSorting pagingSorting) {
		List<Country> results = countryDAO.findAllByFilter(filter, pagingSorting);
		
		return new Page<CountryDTO>(results.stream()
										   .map(c -> countryMapper.toDto(c))
										   .collect(Collectors.toList()), countryDAO.countAllByFilter(filter), pagingSorting.getPageNumber(), pagingSorting.getPageSize());
	}

	public CountryDTO findByCode(String countryCode) {
		return countryMapper.toDto(countryDAO.findById(countryCode));
	}

	@Transactional
	public CountryDTO save(CountryDTO country) {
		Country newCountry = countryDAO.saveOrUpdate(countryMapper.toEntity(country));
		return countryMapper.toDto(newCountry);
	}

	@Transactional
	public CountryDTO update(CountryDTO country, String countryCode) {
		Country updatedCountry = countryDAO.findById(countryCode);

		country.setCode(countryCode);
		updatedCountry = countryDAO.saveOrUpdate(countryMapper.toEntity(country, updatedCountry));
		return countryMapper.toDto(updatedCountry);
	}

	@Transactional
	public void deleteByCode(String countryCode) {
		countryDAO.deleteById(countryCode);
	}
	

	
}
