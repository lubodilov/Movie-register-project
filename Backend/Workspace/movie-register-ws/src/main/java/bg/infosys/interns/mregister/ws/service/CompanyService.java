package bg.infosys.interns.mregister.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.interns.mregister.core.dao.CompanyDAO;
import bg.infosys.interns.mregister.core.entity.Company;
import bg.infosys.interns.mregister.ws.dto.CompanyDTO;
import bg.infosys.interns.mregister.ws.dto.mapper.CompanyMapper;

@Service
public class CompanyService {
	private final CompanyDAO companyDAO;
	private final CompanyMapper companyMapper;
	
	public CompanyService(CompanyDAO companyDAO, CompanyMapper companyMapper)
	{
		this.companyDAO = companyDAO;
		this.companyMapper = companyMapper;
	}

	public List<CompanyDTO> findAll() {
		return companyDAO.findAll().stream()
								 .map(c -> companyMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public CompanyDTO findById(Long companyId) {
		return companyMapper.toDto(companyDAO.findById(companyId));
	}

	@Transactional
	public CompanyDTO save(CompanyDTO company) {
		Company newCompany = companyDAO.saveOrUpdate(companyMapper.toEntity(company));
		return companyMapper.toDto(newCompany);
	}

	@Transactional
	public CompanyDTO update(CompanyDTO company, Long companyId) {
		Company updatedCompany = companyDAO.findById(companyId);
		
		company.setId(companyId);
		updatedCompany = companyDAO.saveOrUpdate(companyMapper.toEntity(company, updatedCompany));
		return companyMapper.toDto(updatedCompany);
	}

	@Transactional
	public void deleteById(Long companyId) {
		companyDAO.deleteById(companyId);
	}
	

	
}
