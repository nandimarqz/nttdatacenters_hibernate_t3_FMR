package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import nttdatacenters_hibernate_t2_FMR.persistence.Department;

/**
 * Interfaz para el DAO de los departamenos
 * 
 * @author nandi
 *
 */
public interface DepartmentDaoI extends DaoI<Department> {

	/**
	 * Devuelve el departamento con el nombre pasado por parametro.
	 * Devuelve unicamente uno ya que el nombre de los departamentos es unico
	 * 
	 * @param name
	 * @return Department
	 */
	public Department getDepartmentByName(String name);
	
	/**
	 * Sobrescribimos el metodo deleteById por la etiqueta en la clase de
	 * persistencia "@PreRemove", ya que al realizar el borrado por sentencia HQL
	 * no llama al metodo con la notacion "@PreRemove"
	 * 
	 */
	@Override
	public void deleteById(Long id);
	
}
