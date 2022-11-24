package nttdatacenters_hibernate_t2_FMR.services.implementations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t2_FMR.exceptions.DepartmentNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingDepartment;
import nttdatacenters_hibernate_t2_FMR.persistence.Department;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations.DepartmentDaoImpl;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.DepartmentDaoI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.DepartmentManagmentServiceI;

/**
 * Implementacion de la interfaz DepartmentManagmentServiceI
 * 
 * @author nandi
 *
 */
public class DepartmentManagmentServiceImpl implements DepartmentManagmentServiceI {

	/** DAO de los departamentos */
	private DepartmentDaoI depDao;
	
	/** Logger para la clase */
	private static final Logger DMSLOG = LoggerFactory.getLogger(DepartmentManagmentServiceImpl.class);

	/**
	 * Constructor Servicio
	 */
	public DepartmentManagmentServiceImpl() {

		DMSLOG.debug("Creado el servicio de gestion de los departamentos");
		// Inyecta el DAO de los departamentos
		depDao = new DepartmentDaoImpl();

	}

	@Override
	public void insertNewDepartment(Department department) throws ExistingDepartment {
		
		DMSLOG.debug("Insertando nuevo departamento");

		// Si el departamento pasado por parametro no es nulo, el id del departamento es
		// nulo y el nombre de departamento es distinto a nulo entra en la condicion
		if (department != null && department.getId() == null && department.getName() != null) {

			// Seteamos el nombre del departamento a su nombre pero en mayuscula
			department.setName(department.getName().toUpperCase());

			// Si el departamento que obtiene el dao es igual a null es que no existe ningun
			// departamento con su nombre entra en la condicion y lo inserta.
			// Si es disitinto a null lanza una excepcion
			if (depDao.getDepartmentByName(department.getName()) == null) {

				DMSLOG.debug("Insertando departamento con id: {}", department.getDepartmentId());
				// Consume el dao y lo inserta
				depDao.insert(department);

			} else {

				DMSLOG.error("El de partamento que se quiere insertar ya existe");
				throw new ExistingDepartment("El departamento que intenta insertar ya existe");

			}

		}

	}

	@Override
	public void updateDepartment(Department department) throws DepartmentNotFound {
		
		// Si el departamento pasado por parametro no es nulo y el id tampoco lo es
		// entra en la condicion
		if (department != null && department.getId() != null) {

			// Si el departamento que obtiene el dao es distinto a nulo es que existe un
			// departamento con su id entra en la condicion y lo actualiza
			// Si es nulo no entra en la condicion y lanza una excepcion
			if (depDao.searchById(department.getId()) != null) {

				DMSLOG.debug("Actualizando el departamento con id:{}", department.getDepartmentId());
				// Consume el dao y actualiza el departamento
				depDao.update(department);

			} else {

				DMSLOG.error("El departamento que se intenta actualizar no existe");
				throw new DepartmentNotFound("El departamento que se intenta actualizar no existe");

			}

		}

	}

	@Override
	public void deleteDepartment(Department department) {

		// Si el departamento es distinto a nulo y su id tampoco lo es entra en la
		// condicion
		if (department != null && department.getId() != null) {

			DMSLOG.debug("Eliminando el departamento con id:{}", department.getId());
			// Consume el dao y borra el departamento pasado por parametro
			depDao.delete(department);

		}

	}

	@Override
	public void deleteDepartmentByd(Long id) {

		// Si el id pasado por parametro es distinto a nulo entra en la condición
		if (id != null) {

			DMSLOG.debug("Eliminando el departamento con id: {}", id);
			// Consume el DAO y borra el departamento con el id pasado por parametro
			depDao.deleteById(id);

		}

	}

	@Override
	public Department getDepartmentById(Long id) {

		// Crea un departamento a null
		Department d = null;

		// Si el id pasado por parametro es distinto a null enta en la condicion
		if (id != null) {

			DMSLOG.debug("Obteniendo el departamento con id: {}", id);
			// Consume el dao y guarda el resultado en la variable
			d = depDao.searchById(id);

		}

		// Devuelve la variable creada
		return d;
	}

	@Override
	public List<Department> getAllDepartments() {

		// Crea una lista de departamentos a null
		List<Department> deps = null;

		DMSLOG.debug("Obteniendo todos los departamentos");
		// Consume el dao y guarda el resultado en la lista
		deps = depDao.searchAll();

		// devuelve la lista
		return deps;
	}

}
