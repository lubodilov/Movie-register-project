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
@Table(schema = "public", name = "organizations")
public class Organization  {
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
	
	@Column(name = _abbreviation)
	private String abbreviation;
	public static final String _abbreviation = "abbreviation";
	
	@ManyToOne
    @JoinColumn(name="location_id", nullable=false)
    private Location location;
	
	@OneToMany(mappedBy="organization", fetch = FetchType.LAZY)
	private List<Award> awards;
	
	@OneToMany(mappedBy="organization", fetch = FetchType.LAZY)
    private List<Actor> actors;
	
	public Organization() {}
	
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
	
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public List<Award> getAwards() {
		return awards;
	}
	
	public void setAwards(List<Award> organizationAward) {
		this.awards = organizationAward;
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	
	public void setActors(List<Actor> organizationActor) {
		this.actors = organizationActor;
	}
}
