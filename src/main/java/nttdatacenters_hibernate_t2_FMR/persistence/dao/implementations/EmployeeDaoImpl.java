package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nttdatacenters_hibernate_t2_FMR.persistence.Employee;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.EmployeeDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;

/**
 * Implementacion de la interfaz del Dao de Empleados
 * 
 * @author nandi
 *
 */
public class EmployeeDaoImpl extends DaoImpl<Employee> implements EmployeeDaoI {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	/**
	 * Constructor sin parametros setea la clase con la que trabaja el DAO genérico
	 */
	public EmployeeDaoImpl() {
		super();
		this.setClazz(Employee.class);
	}

	@Override
	public Employee getEmployeeByDNI(String dni) {

		// Crea un String con una consutla HQL
		String qlString = "FROM Employee WHERE DNI = " + "'" + dni + "'";

		// Crea la consulta y la guarda en una variable
		Query query = entityManager.createQuery(qlString);

		// Crea el objeto de tipo empleado a null
		Employee e = null;

		// Si el resultado de la query esta vacio no entra en la condicion y se devuelve
		// el empleado a nulo
		// Si el resultado de la query no esta vacio entra en la condicion y coge el
		// primer valor de la lista ya que los DNI son unicos
		if (!query.getResultList().isEmpty()) {

			e = (Employee) query.getResultList().get(0);

		}

		// Retorna el Empleado
		return e;
	}

	@Override
	public void deleteById(Long id) {

		// Se obtiene el empleado con el id pasado por paramento
		Employee employee = super.searchById(id);

		// Llama al metodo del padre delete para que borre el empleado que ha obtenido
		// con el id
		super.delete(employee);

	}
}
