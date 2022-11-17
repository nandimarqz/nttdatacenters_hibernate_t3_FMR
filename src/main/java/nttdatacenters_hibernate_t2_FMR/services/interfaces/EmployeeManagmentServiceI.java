package nttdatacenters_hibernate_t2_FMR.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.EmployeeNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingEmployee;
import nttdatacenters_hibernate_t2_FMR.persistence.Employee;

public interface EmployeeManagmentServiceI {

public void insertNewEmployee(Employee employee) throws ExistingEmployee;
	
	public void updateEmployee(Employee employee) throws EmployeeNotFound;
	
	public void deleteEmployee(Employee employee);
	
	public void deleteEmployeeByd(Long id);
	
	public Employee getEmployeeById(Long id);
	
	public List<Employee> getAllEmployees();
}
