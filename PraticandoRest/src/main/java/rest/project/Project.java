package rest.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import rest.employee.Employee;

@Entity
@SequenceGenerator(name="seq_project",
				   sequenceName="seq_project",
				   initialValue=1,
				   allocationSize=1
)
@Table(name="PROJECT")
public class Project {
	
	@ManyToMany
	@JoinTable(name="EMP_PROJ",
			   joinColumns=@JoinColumn(name="PROJ_ID"),
			   inverseJoinColumns=@JoinColumn(name="EMP_ID")
	)
	private List<Employee> employees = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_project")
	@Column(name="id")
	private Long projectId;
	
	@Column(nullable=false, unique=true)
	@Size(min=2, max=300)
	private String name;
	
	public Project() {
		
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}
	
	

}