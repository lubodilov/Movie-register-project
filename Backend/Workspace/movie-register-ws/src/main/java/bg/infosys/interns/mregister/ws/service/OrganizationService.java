package bg.infosys.interns.mregister.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.interns.mregister.core.dao.OrganizationDAO;
import bg.infosys.interns.mregister.core.entity.Organization;
import bg.infosys.interns.mregister.ws.dto.OrganizationDTO;
import bg.infosys.interns.mregister.ws.dto.mapper.OrganizationMapper;

@Service
public class OrganizationService {
	private final OrganizationDAO organizationDAO;
	private final OrganizationMapper organizationMapper;
	
	public OrganizationService(OrganizationDAO organizationDAO, OrganizationMapper organizationMapper)
	{
		this.organizationDAO = organizationDAO;
		this.organizationMapper = organizationMapper;
	}
	
	public List<OrganizationDTO> findAll() {
		return organizationDAO.findAll().stream()
								 .map(c -> organizationMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public OrganizationDTO findById(Long organizationId) {
		return organizationMapper.toDto(organizationDAO.findById(organizationId));
	}

	@Transactional
	public OrganizationDTO save(OrganizationDTO organization) {
		Organization newOrganization = organizationDAO.saveOrUpdate(organizationMapper.toEntity(organization));
		return organizationMapper.toDto(newOrganization);
	}

	@Transactional
	public OrganizationDTO update(OrganizationDTO organization, Long organizationId) {
		Organization updatedOrganization = organizationDAO.findById(organizationId);

		organization.setId(organizationId);
		updatedOrganization = organizationDAO.saveOrUpdate(organizationMapper.toEntity(organization, updatedOrganization));
		return organizationMapper.toDto(updatedOrganization);
	}

	@Transactional
	public void deleteById(Long organizationId) {
		organizationDAO.deleteById(organizationId);
	}
	
}
