package rest.employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import rest.project.Project;

@Entity
@SequenceGenerator(name="seq_employee", 
				   sequenceName="seq_employee",
				   initialValue=1,
				   allocationSize=1
)
@Table(name="EMPLOYEE")
public class Employee {
	
	@ManyToMany(mappedBy="employees")
	@JsonIgnore
	private List<Project> projects = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_employee")
	@Column(name="id")
	private Long employeeId;
	
	@Column(nullable=false)
	@Size(min=2, max=300)
	private String name;
	
	private BigDecimal salary;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}
	
	

}