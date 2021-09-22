package bg.infosys.interns.mregister.ws.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CompanyDTO  {
	private Long id;
	
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date foundation;
	private String website;
    private LocationDTO location;
	
	public CompanyDTO() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long companyId) {
		this.id = companyId;
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
	
	public void setFoundation(Date foundation) {
		this.foundation = foundation;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public LocationDTO getLocation() {
		return location;
	}
	
	public void setLocation(LocationDTO location) {
		this.location = location;
	}
}
