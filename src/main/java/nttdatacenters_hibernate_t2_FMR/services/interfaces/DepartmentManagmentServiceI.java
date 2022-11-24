package nttdatacenters_hibernate_t2_FMR.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.DepartmentNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingDepartment;
import nttdatacenters_hibernate_t2_FMR.persistence.Department;

/**
 * Interfaz del servicio de gestion de los departamentos
 * 
 * @author nandi
 *
 */
public interface DepartmentManagmentServiceI {

	/**
	 * Inserta un nuevo departamento, si el departamento que se inserta exsite lanza
	 * una excepcion
	 * 
	 * @param department
	 * @throws ExistingDepartment
	 */
	public void insertNewDepartment(Department department) throws ExistingDepartment;

	/**
	 * Actualiza un departamento existente, si no existe el departamento que se va a
	 * actualizar lanza una excepcion
	 * 
	 * @param department
	 * @throws DepartmentNotFound
	 */
	public void updateDepartment(Department department) throws DepartmentNotFound;

	/**
	 * Borra un departamento existente
	 * 
	 * @param department
	 */
	public void deleteDepartment(Department department);

	/**
	 * Borra un departamento existente con el id pasado por parametro
	 * @param id
	 */
	public void deleteDepartmentByd(Long id);
	
	/**
	 * Devuelve un departamento existente con el id pasado por parametro
	 * 
	 * @param id
	 * @return Department
	 */
	public Department getDepartmentById(Long id);

	/**
	 * Devuelve una lista con todos los departamentos existentes
	 * 
	 * @return Lista de departamentos
	 */
	public List<Department> getAllDepartments();

}
