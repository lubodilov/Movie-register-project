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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "public", name = "companies")
public class Company  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = _name)
	private String name;
	public static final String _name = "name";
	
	@Column(name = _foundation)
	@Temporal(TemporalType.DATE)
	private Date foundation;
	public static final String _foundation = "foundation";
	
	@Column(name = _website)
	private String website;
	public static final String _website = "website";
	
	@ManyToOne
    @JoinColumn(name="location_id", nullable=false)
    private Location location;
	
	@OneToMany(mappedBy="company", fetch = FetchType.LAZY)
    private List<Movie> movies;
	
	public Company() {}
	
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
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	public void setMovies(List<Movie> companyMovie) {
		this.movies = companyMovie;
	}
}
