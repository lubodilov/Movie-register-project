package bg.infosys.interns.mregister.ws.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AwardDTO  {
	private Long id;
	
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date foundation;
	private boolean isActive;
    private AwardTypeDTO awardType; 
    private OrganizationDTO organization; 
    private AwardDTO awardParent;
	
	public AwardDTO() { }
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long awardId) {
		this.id = awardId;
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
	
	public boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public AwardTypeDTO getAwardType()
	{
		return awardType;
	}
	
	public void setAwardType(AwardTypeDTO awardType)
	{
		this.awardType = awardType;
	}
	
	public OrganizationDTO getOrganization()
	{
		return organization;
	}
	public void setOrganization(OrganizationDTO organization)
	{
		this.organization = organization;
	}
	
	public AwardDTO getAwardParent()
	{
		return awardParent;
	}
	
	public void setAwardParent(AwardDTO awardParent)
	{
		this.awardParent = awardParent;
	}
	
}
