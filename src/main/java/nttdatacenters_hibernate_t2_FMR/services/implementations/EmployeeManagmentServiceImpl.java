package nttdatacenters_hibernate_t2_FMR.services.implementations;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.EmployeeNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingEmployee;
import nttdatacenters_hibernate_t2_FMR.persistence.Employee;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations.EmployeeDaoImpl;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.EmployeeDaoI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.EmployeeManagmentServiceI;

public class EmployeeManagmentServiceImpl implements EmployeeManagmentServiceI {

	EmployeeDaoI empDao;
	
	public EmployeeManagmentServiceImpl() {
		
		empDao = new EmployeeDaoImpl();
		
	}
	
	@Override
	public void insertNewEmployee(Employee employee) throws ExistingEmployee {
		
		if(employee != null && employee.getId() == null && employee.getDni() != null) {
			
			
			if(empDao.getEmployeeByDNI(employee.getDni()) == null) {
				
				empDao.insert(employee);
				
			}else {
				
				throw new ExistingEmployee("El empleado que desea insertar ya existe");
				
			}
			
		}
		
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeNotFound {
		
		if(employee != null && employee.getId() != null) {
			
			if(empDao.searchById(employee.getId()) != null) {
				
				empDao.update(employee);
				
			}else {
				
				throw new EmployeeNotFound("El empleado que se intenta actualizar no existe");
				
			}
			
		}
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		
		if(employee != null && employee.getId() != null) {
			
			empDao.delete(employee);
			
		}
		
	}

	@Override
	public void deleteEmployeeByd(Long id) {
		
		if(id != null) {
			
			empDao.deleteById(id);
			
		}
		
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		Employee e = null;
		
		if(id != null) {
			
			e = empDao.searchById(id);
			
		}
		
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = null;
		
		employees = empDao.searchAll();
		
		return employees;
	}

}
