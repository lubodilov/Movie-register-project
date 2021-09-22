package bg.infosys.interns.mregister.core.paging;

public class CountryPaigingDTO {
	private String name;
	private String code;

	public CountryPaigingDTO(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}