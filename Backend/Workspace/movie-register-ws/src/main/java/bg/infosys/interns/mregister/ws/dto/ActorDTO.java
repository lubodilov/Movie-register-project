package bg.infosys.interns.mregister.ws.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ActorDTO  {
	private Long id;
	
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	private boolean isActive;
    private LocationDTO location;
    private OrganizationDTO organization;
	
	public ActorDTO() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long integer) {
		this.id = integer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date localDate) {
		this.dateOfBirth = localDate;
	}
	
	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public LocationDTO getLocation()
	{
		return location;
	}
	
	public void setLocation(LocationDTO location)
	{
		this.location = location;
	}
	
	public OrganizationDTO getOrganization()
	{
		return organization;
	}
	
	public void setOrganization(OrganizationDTO organization)
	{
		this.organization = organization;
	}
	
}
