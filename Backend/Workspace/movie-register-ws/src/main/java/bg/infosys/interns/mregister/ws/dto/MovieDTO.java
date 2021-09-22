package bg.infosys.interns.mregister.ws.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MovieDTO  {
	private Long id;
	
	private String name;
	private String director;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;
	private Float budget;
	private Float boxOffice;
    private CountryDTO country;
    private CompanyDTO company;
    private GenreDTO genre;
	
	public MovieDTO() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long movieId) {
		this.id = movieId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public Float getBudget() {
		return budget;
	}
	
	public void setBudget(Float budget) {
		this.budget = budget;
	}
	
	public Float getBoxOffice() {
		return boxOffice;
	}
	
	public void setBoxOffice(Float boxOffice) {
		this.boxOffice = boxOffice;
	}
	
	public CountryDTO getCountry()
	{
		return country;
	}
	
	public void setCountry(CountryDTO country)
	{
		this.country = country;
	}
	
	public CompanyDTO getCompany()
	{
		return company;
	}
	
	public void setCompany(CompanyDTO company)
	{
		this.company = company;
	}
	
	public GenreDTO getGenre()
	{
		return genre;
	}
	
	public void setGenre(GenreDTO genre)
	{
		this.genre = genre;
	}
	
}
