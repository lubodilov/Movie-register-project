package bg.infosys.interns.mregister.core.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "public", name = "movies")
public class Movie  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = _name)
	private String name;
	public static final String _name = "name";
	
	@Column(name = _director)
	private String director;
	public static final String _director = "director";
	
	@Column(name = _release)
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	public static final String _release = "release";
	
	@Column(name = _budget)
	private Float budget;
	public static final String _budget = "budget";
	
	@Column(name = _box_office)
	private Float boxOffice;
	public static final String _box_office = "box_office";
	
	@ManyToOne
    @JoinColumn(name = "country_id" , nullable=false)
    private Country country;
	
	@ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;
	
	@ManyToOne
    @JoinColumn(name="genre_id", nullable=false)
    private Genre genre;
	
	@ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
	List<Actor> actors;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	  name = "movies_locations", 
	  joinColumns = @JoinColumn(name = "movies_id"), 
	  inverseJoinColumns = @JoinColumn(name = "locations_id"))
	List<Location> locations;
	
	public Movie() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Company getCompany()	{
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	
	public void setActors(List<Actor> movieActor) {
		this.actors = movieActor;
	}
	
	public List<Location> getLocations() {
		return locations;
	}
	
	public void setLocations(List<Location> movieLocation) {
		this.locations = movieLocation;
	}
}
