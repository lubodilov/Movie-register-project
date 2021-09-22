package bg.infosys.interns.mregister.ws.dto;

public class LocationDTO  {
	private Long id;
	
	private String address;
    private CountryDTO country;

    public LocationDTO () {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long locationId) {
		this.id = locationId;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public CountryDTO getCountry() {
		return country;
	}
	
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	
}