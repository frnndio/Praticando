package rest.employee;

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

@RestController
@RequestMapping(value="/employee", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmployeeController {

	private final EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity getTodos() {
		try {
			List<Employee> resultado = service.recuperarTodos();
			if(!resultado.isEmpty()) {
				return ResponseEntity.ok(resultado);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity getPorId(@PathVariable Long employeeId) {
		try {
			Employee resultado = service.recuperarPorId(employeeId);
			if(!resultado.equals(null)) {

				return ResponseEntity.ok(resultado);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity post(@RequestBody Employee employee) {
		try {
			this.service.salvar(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(employee.getEmployeeId());
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity update(@RequestBody Employee employee) {
		try {
			this.service.salvar(employee);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity delete(@PathVariable Long employeeId) {
		try {
			service.deletar(employeeId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}