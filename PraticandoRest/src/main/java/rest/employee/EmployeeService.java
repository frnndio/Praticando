package rest.employee;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<Employee> recuperarTodos() throws ServiceException {
		return repository.findAll();
	}

	public Employee recuperarPorId(Long id) throws ServiceException {
		return repository.getOne(id);
	}

	public Employee salvar(Employee employee) throws ServiceException {
		return repository.save(employee);
	}

	public void deletar(Long id) throws ServiceException {
		repository.deleteById(id);
	}

}