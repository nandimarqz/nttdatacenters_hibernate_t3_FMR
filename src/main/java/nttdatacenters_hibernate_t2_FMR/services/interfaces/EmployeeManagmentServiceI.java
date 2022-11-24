package nttdatacenters_hibernate_t2_FMR.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.EmployeeNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingEmployee;
import nttdatacenters_hibernate_t2_FMR.persistence.Employee;

/**
 * Interfaz del servicio de gestion de lo empleados
 * 
 * @author nandi
 *
 */
public interface EmployeeManagmentServiceI {

	/**
	 * Inseta un nuevo empleado, si el empleado que inserta existe lanza una
	 * excepcion
	 * 
	 * @param employee
	 * @throws ExistingEmployee
	 */
	public void insertNewEmployee(Employee employee) throws ExistingEmployee;

	/**
	 * Actualiza un empleado existente, si no existe el empleado que se va a
	 * actualizar lanza una excepcion
	 * 
	 * @param employee
	 * @throws EmployeeNotFound
	 */
	public void updateEmployee(Employee employee) throws EmployeeNotFound;

	/**
	 * Borra el empleado pasado por parametro
	 * 
	 * @param employee
	 */
	public void deleteEmployee(Employee employee);

	/**
	 * Borra el empleado con el id que se pasa por parametro
	 * 
	 * @param id
	 */
	public void deleteEmployeeByd(Long id);

	/**
	 * Devuelve el empleado con el id pasado por parametro
	 * 
	 * @param id
	 * @return Employee
	 */
	public Employee getEmployeeById(Long id);
	
	/**
	 * Devuelve una lista con todos los empleados
	 * 
	 * @return lista de empleados
	 */
	public List<Employee> getAllEmployees();
}
