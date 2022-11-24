package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import nttdatacenters_hibernate_t2_FMR.persistence.Employee;

/**
 * Interfaz para el DAO de empleados
 * 
 * @author nandi
 *
 */
public interface EmployeeDaoI extends DaoI<Employee> {

	/**
	 * Devuelve el empleado que tenga el DNI pasado por parametro
	 * 
	 * @param dni
	 * @return Employee
	 */
	public Employee getEmployeeByDNI(String dni);

	/**
	 * Sobrescribimos el metodo deleteById por la etiqueta en la clase de
	 * persistencia "@PreRemove", ya que al realizar el borrado por sentencia HQL
	 * no llama al metodo con la notacion "@PreRemove"
	 * 
	 */
	@Override
	public void deleteById(Long id);
}
