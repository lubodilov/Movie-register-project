package bg.infosys.interns.mregister.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "awards_type")
public class AwardType  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = _code)
	private String code;
	public static final String _code = "code";
	
	@Column(name = _name)
	private String name;
	public static final String _name = "name";
	
	@Column(name = _description)
	private String description;
	public static final String _description = "description";
	
	@OneToMany(mappedBy="awardType", fetch = FetchType.LAZY)
    private List<Award> awards;
	
	public AwardType() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Award> getAwards() {
		return awards;
	}
	
	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}
}
