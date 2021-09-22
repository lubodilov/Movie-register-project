package bg.infosys.interns.mregister.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "locations")
public class Location  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = _address)
	private String address;
	public static final String _address = "address";
	
	@ManyToOne
    @JoinColumn(name="country_id", nullable=false)
    private Country country;
	
	@OneToMany(mappedBy="location", fetch = FetchType.LAZY)
    private List<Company> companies;
	
	@OneToMany(mappedBy="location", fetch = FetchType.LAZY)
    private List<Organization> organizations;

	@OneToMany(mappedBy="location", fetch = FetchType.LAZY)
    private List<Actor> actors;
	
	@ManyToMany(mappedBy = "locations",fetch = FetchType.LAZY)
	List<Movie> movies;
	
	public Location () {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public List<Company> getCompanies() {
		return companies;
	}
	
	public void setCompanies(List<Company> locationCompany) {
		this.companies = locationCompany;
	}
	
	public List<Organization> getOrganizations() {
		return organizations;
	}
	
	public void setOrganizations(List<Organization> locationOrganization) {
		this.organizations = locationOrganization;
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	
	public void setActors(List<Actor> locationActor) {
		this.actors = locationActor;
	}
	
	public List<Movie> getMovies(){
		return movies;
	}
	
	public void setMovies(List<Movie> locationMovie){
		this.movies = locationMovie;
	}
	
}