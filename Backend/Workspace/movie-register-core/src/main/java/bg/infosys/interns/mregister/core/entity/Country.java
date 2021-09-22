package bg.infosys.interns.mregister.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "countries")
public class Country  {
	@Id
	@Column(name = _code)
	private String code;
	public static final String _code = "code";
	
	@Column(name = _name)
	private String name;
	public static final String _name = "name";
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<Location> locations;
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<Movie> movies;
	
	public Country() {}

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
	
	public List<Location> getCountryLocation()	{
		return locations;
	}
	
	public void setCountryLocation(List<Location> countryLocation)	{
		this.locations = countryLocation;
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	public void setyMovies(List<Movie> countryMovie) {
		this.movies = countryMovie;
	}

	
}