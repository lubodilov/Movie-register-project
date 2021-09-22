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
@Table(schema = "public", name = "actors")
public class Actor  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = _name)
	private String name;
	public static final String _name = "name";
	
	@Column(name = _date_Of_birth)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	public static final String _date_Of_birth = "date_Of_birth";

	
	@Column(name = _is_active)
	private boolean isActive;
	public static final String _is_active = "is_active";
	
	@ManyToOne
    @JoinColumn(name="birthplace_id", nullable=false)
    private Location location;
	
	@ManyToOne
    @JoinColumn(name="organization_id", nullable=false)
    private Organization organization;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	  name = "actors_awards", 
	  joinColumns = @JoinColumn(name = "actors_id"), 
	  inverseJoinColumns = @JoinColumn(name = "awards_id"))
	List<Award> awards;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	  name = "actors_movies", 
	  joinColumns = @JoinColumn(name = "actors_id"), 
	  inverseJoinColumns = @JoinColumn(name = "movies_id"))
	List<Movie> movies;
	
	public Actor() {}
	
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
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public List<Award> getAwards() {
		return awards;
	}
	
	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
