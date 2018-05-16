package rest.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import rest.employee.Employee;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	@Transactional
	@Query("SELECT e FROM Employee e INNER JOIN e.projects p WHERE p.id = :projectId AND e.id = :employeeId")
	public Employee pesquisarFuncionarioNoProjetoPorId(@Param("employeeId") Long employeeId, @Param("projectId") Long projectId);

	@Transactional
	@Query("SELECT p FROM Project p INNER JOIN p.employees e WHERE e.id = :employeeId")
	public List<Project> pesquisarProjetosDoFuncionarioPorId(@Param("employeeId") Long employeeId);

	@Transactional
	@Query("SELECT e FROM Employee e INNER JOIN e.projects p GROUP BY p.id HAVING COUNT(p) > 1")	
	public List<Employee> pesquisarFuncionariosEmMaisDeUmProjeto();
	
}