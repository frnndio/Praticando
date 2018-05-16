package rest.project;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.employee.Employee;
import rest.employee.EmployeeService;

@Service
@Transactional
public class ProjectService {
	
	@Autowired
	private ProjectRepository repository;
	
	@Autowired
	EmployeeService employeeService = new EmployeeService();
	
	public List<Project> recuperarTodos() throws ServiceException {
		return repository.findAll();
	}

	public Project recuperarPorId(Long id) throws ServiceException {
		return repository.getOne(id);
	}
	
	public Project salvar(Project project) throws ServiceException {
		return repository.save(project);
	}
	
	public void deletar(Long id) throws ServiceException {
		repository.deleteById(id);
	}

	public void adicionarFuncionarioAoProjeto(Long employeeId, Long projectId) {
				
		if (funcionarioEstaAptoParaEntrarNoProjeto(employeeId, projectId)) {
			Project project = recuperarPorId(projectId);
			project.getEmployees().add(employeeService.recuperarPorId(employeeId));
			repository.save(project);
		}
		
		
	}
	
	public List<Employee> listarFuncionariosEmMaisDeUmProjeto() {		
		return repository.pesquisarFuncionariosEmMaisDeUmProjeto();
	}
	
	private boolean funcionarioEstaAptoParaEntrarNoProjeto(Long employeeId, Long projectId) {
		if (!funcionarioJaEstaNoProjeto(employeeId, projectId) && !funcionarioEstaEmDoisProjetos(employeeId)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean funcionarioJaEstaNoProjeto(Long employeeId, Long projectId) {
		Employee resultado = repository.pesquisarFuncionarioNoProjetoPorId(employeeId, projectId);
		if(resultado != null) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean funcionarioEstaEmDoisProjetos(Long employeeId) {
		List<Project> resultado = repository.pesquisarProjetosDoFuncionarioPorId(employeeId);
		if(resultado.size() >= 2) {
			return true;
		} else {
			return false;
		}
	}
	

}