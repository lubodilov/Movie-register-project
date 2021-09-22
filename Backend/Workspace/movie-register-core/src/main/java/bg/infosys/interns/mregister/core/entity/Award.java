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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "public", name = "awards")
public class Award  {
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
	
	@Column(name = _is_active)
	private boolean isActive;
	public static final String _is_active = "is_active";
	
	@ManyToOne
    @JoinColumn(name="type_id", nullable=false)
    private AwardType awardType; 

	@ManyToOne
    @JoinColumn(name="organization_id", nullable=false)
    private Organization organization; 
	
	@ManyToOne
    @JoinColumn(name="parent_id", nullable=true)
    private Award awardParent;
	
	@OneToMany(mappedBy="awardParent", fetch = FetchType.LAZY)
    private List<Award> awardChild;
	
	@ManyToMany(mappedBy = "awards", fetch = FetchType.LAZY)
	List<Actor> actors;
	
	public Award () {}
	
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
	
	public boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public AwardType getAwardType()
	{
		return awardType;
	}
	
	public void setAwardType(AwardType awardType) {
		this.awardType = awardType;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public Award getAwardParent() {
		return awardParent;
	}
	
	public void setAwardParent(Award awardParent) {
		this.awardParent = awardParent;
	}
	
	public List<Award> getAwardChild() {
		return awardChild;
	}
	
	public void setAwardChild(List<Award> awardChild) {
		this.awardChild = awardChild;
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
}
