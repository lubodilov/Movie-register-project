package bg.infosys.interns.mregister.ws.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrganizationDTO  {
	private Long id;
	
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date foundation;
	private String abbreviation;
    private LocationDTO location;
	
	public OrganizationDTO() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long organizationId) {
		this.id = organizationId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getFoundation() {
		return foundation;
	}

	public void setFoundation(Date localDate) {
		this.foundation = localDate;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public LocationDTO getLocation() {
		return location;
	}
	
	public void setLocation(LocationDTO location) {
		this.location = location;
	}
	
}
