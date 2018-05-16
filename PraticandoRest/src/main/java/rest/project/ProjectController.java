package rest.project;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.employee.Employee;

@RestController
@RequestMapping(value="/project", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectController {
	
	private final ProjectService service;
	
	@Autowired
	public ProjectController(ProjectService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity getTodos() {
		try {
			List<Project> resultado = service.recuperarTodos();
			if (!resultado.isEmpty()) {
				return ResponseEntity.ok(resultado);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity getPorId(@PathVariable Long projectId) {
		try {
			Project resultado = service.recuperarPorId(projectId);
			if(!resultado.equals(null)) {
				return ResponseEntity.ok(resultado);
			} else { 
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/FuncionariosEmMaisDeUmProjeto")
	public ResponseEntity getFuncionariosEmMaisDeUmProjeto() {
		try {
			List<Employee> resultado = service.listarFuncionariosEmMaisDeUmProjeto();
			if(!resultado.isEmpty()) {
				return ResponseEntity.ok(resultado);
			} else { 
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}		
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity post(@RequestBody Project project) {
		try {
			this.service.salvar(project);
			return ResponseEntity.status(HttpStatus.CREATED).body(project.getProjectId());
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity update(@RequestBody Project project) {
		try {
			this.service.salvar(project);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity delete(@PathVariable Long projectId) {
		try {
			service.deletar(projectId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/adicionarFuncionarioAoProjeto/{employeeId}")
	public ResponseEntity adicionarFuncionarioAoProjeto(@PathVariable Long employeeId, @RequestBody Project project) {
		try {
			service.adicionarFuncionarioAoProjeto(employeeId, project.getProjectId());
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}