package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nttdatacenters_hibernate_t2_FMR.persistence.Department;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.DepartmentDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;

/**
 * Implementacion de la interfaz del Dao de departamento
 * 
 * @author nandi
 *
 */
public class DepartmentDaoImpl extends DaoImpl<Department> implements DepartmentDaoI {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	/**
	 * Constructor sin parametros setea la clase con la que trabaja el DAO genérico
	 */
	public DepartmentDaoImpl() {
		super();
		this.setClazz(Department.class);
	}

	@Override
	public Department getDepartmentByName(String name) {

		// Crea un String con la consulta HQL
		String qlString = "FROM Department WHERE NAME = " + "'" + name + "'";

		// Crea la consulta y lo guarda en una variable
		Query query = entityManager.createQuery(qlString);

		// Crea el objeto departamento y lo pone a null
		Department d = null;

		// Si el resultado que da la query no esta vacio entra en la condicion
		// y se obtiene el primer elemento ya que el nombre de los departamentos es
		// unico
		//Si esta vacio no entra en la condicion y se devuelve el departamento en null
		if (!query.getResultList().isEmpty()) {

			d = (Department) query.getResultList().get(0);

		}

		//Retorna el departamento
		return d;
	}

	@Override
	public void deleteById(Long id) {

		//Busca el departamento con el id pasado por parametro
		Department department = super.searchById(id);

		// Llama al metodo delete del padre para borrar el departamento
		super.delete(department);

	}

}
